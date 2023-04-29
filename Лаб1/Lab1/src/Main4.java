/**
 * Класс, вычисляющий факториал целого числа
 * @author Бабаскин Никита, гр.12002006 <1560213@bsu.edu.ru>;
 */
public class Main4 {
    static int calculateFactorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(calculateFactorial(4));
    }
}
