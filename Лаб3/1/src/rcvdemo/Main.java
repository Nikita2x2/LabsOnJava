package rcvdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.*;
/**
 * Программа, для решения восьми заданий, в которой выбор осуществляется посредством меню, а переменные считываются из файла и консоли
 * @author Бабаскин Никита, гр.12002006 "1560213@bsu.edu.ru";
 */
public class Main {
    /**
     * Подключение логирования в программу
     */
    private static Logger demoLogger = LogManager.getLogger(Main.class.getName());
    /**
     * Создание переменных
     */
    private static double number = 0.0;
    private static double hours = 0.0;
    private static int dayOfWeek = 0;
    private static int n = 0;
    private static double a = 0.0;
    private static double b = 0.0;
    private static double c = 0.0;
    /**
     * Метод, отвечающий за работу меню, т.е. при нажатии на одну из цифр открывается соответствующий метод
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Выберите задание:");
            System.out.println("1. Вычислить значения выражения.");
            System.out.println("2. Вычислить периметр и площадь прямоугольного треугольника.");
            System.out.println("3. Возвести числа в квадрат или четвертую степень.");
            System.out.println("4. Удвоить числа или заменить их абсолютными значениями.");
            System.out.println("5. Выдать количество уроков.");
            System.out.println("6. Найти сумму первой и последней цифр.");
            System.out.println("7. Определить количество амеб.");
            System.out.println("8. Вычислить произведение ряда.");
            System.out.println("0. Выход.");
            demoLogger.info("Меню хорошо функционирует");
            demoLogger.debug("Меню отлажено");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Введите a, b и c:");
                    readDouble(choice);
                    double result1 = calculateExpression(a, b, c);
                    System.out.println("Результат: " + result1);
                    demoLogger.debug("Задание 1 работает");
                    break;
                case 2:
                    System.out.println("Введите длины катетов:");
                    readDouble(choice);
                    double[] result2 = calculateTriangle(a, b);
                    System.out.println("Периметр: " + result2[0] + ", Площадь: " + result2[1]);
                    demoLogger.debug("Задание 2 работает");
                    break;
                case 3:
                    System.out.println("Введите три числа:");
                    readDouble(choice);
                    powNumbers(a, b, c);
                    demoLogger.debug("Задание 3 работает");
                    break;
                case 4:
                    System.out.println("Введите три числа:");
                    readDouble(choice);
                    double[] result4 = doubleOrAbsolute(a, b, c);
                    for (double num : result4) {
                        System.out.printf("%.2f ", num);
                    }
                    System.out.println();
                    demoLogger.debug("Задание 4 работает");
                    break;
                case 5:
                    readDouble(choice);
                    System.out.println("Введите номер дня недели:");
                    getNumberOfLessons();
                    demoLogger.debug("Задание 5 работает");
                    break;
                case 6:
                    System.out.println("Введите число:");
                    readDouble(choice);
                    double sum = getSum(number);
                    System.out.println("Сумма первой и последней цифр: " + sum);
                    demoLogger.debug("Задание 6 работает");
                    break;
                case 7:
                    System.out.println("Введите количество часов:");
                    readDouble(choice);
                    double numAmoebas = getNumAmoebas(hours);
                    System.out.println("Количество амеб: " + numAmoebas);
                    demoLogger.debug("Задание 7 работает");
                    break;
                case 8:
                    System.out.println("Введите число:");
                    readDouble(choice);
                    double product = calculateProduct(n);
                    System.out.println("Произведение ряда: " + product);
                    demoLogger.debug("Задание 8 работает");
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    demoLogger.error("Ошибка ввода данных");
            }
            System.out.println("===========");
        } while (choice != 0);
    }
    /**
     * Метод реализующий чтение из файла
     */
    private static void readDouble(int choice){

        String path = "D:\\Professional activity\\Study\\БелГУ\\3 курс\\6 семестр\\РППЯВУ\\Лаб2\\input.txt";

        try {
            Scanner in = new Scanner(new File(path));

            try {
                if (choice == 1)
                {
                    a = (double)in.nextInt();
                    b = (double)in.nextInt();
                    c = (double)in.nextInt();
                    System.out.print("a = " + a + "\nb = " + b + "\nc = " + c + "\n");
                }
                if (choice == 2)
                {
                    a = (double)in.nextInt();
                    b = (double)in.nextInt();
                    System.out.print("a = " + a + "\nb = " + b + "\n");
                }
                if (choice == 3)
                {
                    a = (double)in.nextInt();
                    b = (double)in.nextInt();
                    c = (double)in.nextInt();
                    System.out.print("a = " + a + "\nb = " + b + "\nc = " + c + "\n");
                }
                if (choice == 4)
                {
                    a = (double)in.nextInt();
                    b = (double)in.nextInt();
                    c = (double)in.nextInt();
                    System.out.print("a = " + a + "\nb = " + b + "\nc = " + c + "\n");
                }
                if (choice == 5)
                {
                    dayOfWeek = in.nextInt();
                    System.out.print(dayOfWeek + "\n");
                }
                if (choice == 6)
                {
                    number = in.nextInt();
                    System.out.print(number + "\n");
                }
                if (choice == 7)
                {
                    hours = in.nextInt();
                    System.out.print(hours + "\n");
                }
                if (choice == 8)
                {
                    n = in.nextInt();
                    System.out.print(n + "\n");
                }
            } catch (Throwable var6) {
                try {
                    in.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }
                throw var6;
            }

            in.close();
        } catch (FileNotFoundException var7) {
            System.out.println("Ошибка " + var7 + "! файл " + path + " не найден!");
            demoLogger.error("Ошибка поиска файла");
        } catch (InputMismatchException var8) {
            System.out.println("Ошибка " + var8 + "! Не соответствие типов данных!");
            demoLogger.error("Ошибка несоответствия типов данных");
        }
    }
    /**
     * Метод, вычисляющий выражение по формуле
     */
    private static double calculateExpression(double a, double b, double c) {
        return (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a) + Math.pow(a, 3) * c + Math.pow(b, -2);
    }
    /**
     * Метод, вычисляющий периметр и площадь прямоугольного треугольника по заданным длинам двух катетов а и b.
     */
    private static double[] calculateTriangle(double a, double b) {
        double c = Math.sqrt(Math.pow (a, 2) + Math.pow (b, 2));
        double perimeter = a + b + c;
        double area = a * b / 2;
        return new double[]{perimeter, area};
    }
    /**
     * Метод, возводящий в квадрат положительные числа, а в четвертую степень - отрицательные
     */
    private static double powNumbers(double a, double b, double c) {
        double[] result = new double[3];
        if (a >= 0) {
            result[0] = Math.pow (a, 2);
        } else {
            result[0] = Math.pow (a, 4);
        }
        if (b >= 0) {
            result[1] = Math.pow (b, 2);
        } else {
            result[1] = Math.pow (b, 4);
        }
        if (c >= 0) {
            result[2] = Math.pow (c, 2);
        } else {
            result[2] = Math.pow (c, 4);
        }
        for (int i=0; i < 3; i++)
            System.out.println(result[i]);

        return a;
    }
    /**
     * Метод, который удваивает числа a,b,c, если a<b<c, в противном случае заменить их абсолютными значениями
     */
    private static double[] doubleOrAbsolute(double a, double b, double c) {
        if (a < b && b < c) {
            return new double[]{a * 2, b * 2, c * 2};
        } else {
            return new double[]{Math.abs(a), Math.abs(b), Math.abs(c)};
        }
    }
    /**
     * Метод, который при выборе дня недели выдает количество уроков в этот день
     */
    private static void getNumberOfLessons() {
        final int Monday = 1;
        final int Tuesday = 2;
        final int Wednesday = 3;
        final int Thursday = 4;
        final int Friday = 5;
        final int Saturday = 6;
        final int Sunday = 7;
        switch (dayOfWeek) {
            case Monday: {System.out.println("Количество уроков: " + 5);break;}
            case Tuesday: {System.out.println("Количество уроков: " + 3);break;}
            case Wednesday: {System.out.println("Количество уроков: " + 6);break;}
            case Thursday: {System.out.println("Количество уроков: " + 5);break;}
            case Friday: {System.out.println("Количество уроков: " + 4);break;}
            case Saturday: {System.out.println("Количество уроков: " + 2);break;}
            case Sunday: {System.out.println("Количество уроков: " + 0);break;}
            default:
                System.out.println("Такого дня недели не существует");
                demoLogger.error("Ошибка ввода несуществующего дня недели");
        }
    }
    /**
     * Метод, который первую и последнюю цифру первого и последнего числа
     */
    private static double getSum(double number) {
        String strNum = Double.toString(number);
        double sum = strNum.charAt(0) - '0';
        sum += strNum.charAt(strNum.length() - 1) - '0';
        return sum;
    }
    /**
     * Метод, который определяет количество анеб через определенное время
     */
    private static double getNumAmoebas(double hours) {
        double numAmoebas = 1;
        for (int i = 3; i <= hours; i += 3) {
            numAmoebas *= 2;
        }
        return numAmoebas;
    }
    /**
     * Метод, вычисляющий произведение n членов рядов по формуле
     */
    private static double calculateProduct(int n) {
        double product = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                product *= (double) (2 * i) / (2 * i + 1);
            }
        }
        return product;
    }
}