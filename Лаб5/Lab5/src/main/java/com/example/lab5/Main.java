package com.example.lab5;

import java.io.*;
import java.util.ArrayList;
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
    public int n;
    public Task(int n){
        this.n=n;
    }
/**
 *   Метод, который будет выполняться в потоке
 *   Он считывает данные из файла в формате, заданном в условии задачи, и выполняет над ними заданные операции
 *   Результат записывается в выходной файл out.dat
 */
    @Override
    public void run() {
        try {
            File inFile = new File(String.format("in_%d.dat", n));
            Scanner fr = new Scanner(inFile);
            int opType = fr.nextInt();

            double a = fr.nextDouble();
            double b = fr.nextDouble();
            fr.close();

            double result = 0;
            switch (opType){
                case 1: result = a + b;
                    break;
                case 2: result = a * b;
                    break;
                case 3: result = Math.pow(a,2) + Math.pow(b,2);
                    break;
                default:
                    System.out.println("Неверный номер операции");
            }
                FileWriter fw = new FileWriter("out.dat", true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(result);
                pw.close();

        } catch(IOException e) {
            System.out.println(String.format("Error while processing file in_%d.dat: %s", n, e.getMessage()));
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
        for (int i=1; i<4; i++){
            Thread t = new Thread(new Task(i));
            threadList.add(t);
            t.start();
        }
        for (int i=0; i<threadList.size(); i++){
            threadList.get(i).join();
        }
    }
}