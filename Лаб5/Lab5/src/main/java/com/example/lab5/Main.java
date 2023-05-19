package com.example.lab5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Программа считывающая
 * @autor Бабаскин Никита
 */

/**
 * Класс, который реализует интерфейс Runnable. Он содержит единственный конструктор Task(int n) для задания номера файла
 */
class Task implements Runnable {
    private int n;
    private LinkedHashMap<Integer, Double> resultMap;

    public Task(int n, LinkedHashMap<Integer, Double> resultMap) {
        this.n = n;
        this.resultMap = resultMap;
    }
    /**
     * Метод, который будет выполняться в потоке
     * Он считывает данные из файла в формате, заданном в условии задачи, и выполняет над ними заданные операции
     * Результат записывается в выходной файл out.dat
     */
    @Override
    public void run() {
        try {
            File inFile = new File(String.format("in_%d.dat", n));
            Scanner fr = new Scanner(inFile);

            int opType = fr.nextInt();
            fr.nextLine(); // Чтение пустой строки

            List<Double> values = new ArrayList<>();
            while (fr.hasNext()) {
                double value = Double.parseDouble(fr.next().replace(",", "."));
                values.add(value);
            }

            double result = 0;
            switch (opType) {
                case 1:
                    result = values.stream().mapToDouble(Double::doubleValue).sum();
                    break;
                case 2:
                    result = values.stream().reduce(1.0, (a, b) -> a * b);
                    break;
                case 3:
                    result = values.stream().mapToDouble(v -> Math.pow(v, 2)).sum();
                    break;
                default:
                    System.out.println("Неверный номер операции");
            }

            System.out.println("Результат для файла in_" + n + ".dat: " + result);

            fr.close();

            synchronized (resultMap) {
                resultMap.put(n, result);
                writeResultToFile(result);
            }
        } catch (IOException e) {
            System.out.println(String.format("Error while processing file in_%d.dat: %s", n, e.getMessage()));
        }
    }
    /**
     * Метод для записи результата в файл out.dat
     */
    private void writeResultToFile(double result) throws IOException {
        synchronized (Main.class) {
            File outFile = new File("out.dat");
            FileWriter fw = new FileWriter(outFile, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(result);
            pw.close();
        }
    }
}
/**
 * Класс, создающий список потоков, соответствующих задачам
 * Каждому потоку соответствует свой экземпляр класса Task
 * Затем потоки запускаются методом start()
 * После этого вызывается метод join() для каждого потока, чтобы дождаться, пока все потоки завершат свою работу
 * Это необходимо для того, чтобы гарантировать корректное завершение программы.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        LinkedHashMap<Integer, Double> resultMap = new LinkedHashMap<>();

        for (int i = 1; i < 4; i++) {
            Thread t = new Thread(new Task(i, resultMap));
            threadList.add(t);
            t.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        double sum = resultMap.values().stream().mapToDouble(Double::doubleValue).sum();

        System.out.println("Сумма результатов: " + sum);
    }
}