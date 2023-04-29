import java.util.*;
/**
 * Класс, выполняющий задание: Ввести с консоли 3 целых числа. На консоль вывести: Четные и нечетные числа.
 * @author Бабаскин Никита, гр.12002006 <1560213@bsu.edu.ru>;
 */
public class Var1 {
    /** Метод, создающий списки для четных и нечетных чисел*/
    private static List<Integer> even = new ArrayList<Integer>();
    private static List<Integer> odd = new ArrayList<Integer>();

    /** Метод, распределяющий, введенные пользователям числа на четные и нечетные*/
    public static void main(String[] args) {
        System.out.print("Количество чисел: ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        if (size == 0) {
            System.exit(0);
        }
        Integer[] numbers = new Integer[size];
        System.out.print("Введите целые числа через enter ");

        for (int i = 0; i < size; i++)
            numbers[i] = in.nextInt();

        for (int i = 0; i < size; i++) {
            if (numbers[i] % 2 == 0)
                even.add(numbers[i]);
            else
                odd.add(numbers[i]);
        }
        System.out.println("Чётные числа: " + even);
        System.out.println("Нечётные числа: " + odd);
    }
}