/**
 * Класс, перебирающий числа от 1 до 500
 * @author Бабаскин Никита, гр.12002006 "1560213@bsu.edu.ru";
 */
public class Main {
    public static final String  fizz = "fizz";
    public static final String  buzz = "buzz";
    public static final int MAX_INT_NUMBER = 500;
    public static void main(String[] args) {
        for(int i=1; i<=MAX_INT_NUMBER; i++){
            if (i%5==0 & i%7==0) {
                System.out.println(fizz+buzz);
            }
            else  if(i%7==0){
                System.out.println(buzz);
            }
            else if (i%5==0){
                System.out.println(fizz);
            }
            else {
                System.out.println(i);
            }
        }
    }
}