/**
 * Класс, выводящий переданные аргументы в обратном порядке
 * @author Бабаскин Никита, гр.12002006 "1560213@bsu.edu.ru";
 */
public class Main2 {
    public static void main (String [] args){
        int i;
        String string = "Hello world";
        char[] result = string.toCharArray();
        for (i = 10; i >= 0; i--)
            System.out.println(result[i]);
    }
}
