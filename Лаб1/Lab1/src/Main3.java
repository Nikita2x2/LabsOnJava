/**
 * Класс, вычисляющий числа Фибоначчи
 * @author Бабаскин Никита, гр.12002006 "1560213@bsu.edu.ru";
 */
public class Main3 {
    public static void main (String[] args){
        int n0 = 1;
        int n1 = 1;
        int n2;
        System.out.print(n0+" "+n1+" ");
        for(int i = 3; i <= 11; i++){
            n2=n0+n1;
            System.out.print(n2+" ");
            n0=n1;
            n1=n2;
        }
        System.out.println();
    }
}
