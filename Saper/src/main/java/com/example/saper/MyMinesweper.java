public class MyMinesweper {
    public static void main(String[]args) {
        int m=Integer.parseInt(args[0]);
        int n=Integer.parseInt(args[1]);
        int p=Integer.parseInt(args[2]);
        int bomb=0;
        int count=-1;
        String [][]sap=new String[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                sap[i][j]=".";
                bomb=(int)(Math.random()*p);
                if(bomb==0) {
                    for(int k=0; k<m; k++)
                        for(int z=0; z<n; z++)
                            sap[k][z]=".";
                }
                sap[i][bomb]="*";
                sap[bomb][j]="*";

                //peretasovka

                for(int o=0; o<sap.length; o++) {
                    for(int l=0; l<sap.length; l++) {
                        int peret=(int)(Math.random()*sap.length);
                        int peret2=(int)(Math.random()*sap.length);

                        String temp=sap[o][l];
                        sap[o][l]=sap[peret][peret2];
                        sap[peret][peret2]=temp;
                        if(temp==null)
                            temp=".";
                        if(sap[o][l]==null)
                            sap[o][l]=".";
                        if(sap[peret][peret2]==null)
                            sap[peret][peret2]=".";
                    }

                }
                count++;
                if(count==n) {
                    System.out.println();
                    count=0;}
                System.out.print(sap[i][j]);

            }

        }
    }


}