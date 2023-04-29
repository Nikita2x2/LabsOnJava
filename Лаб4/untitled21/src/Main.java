import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Задания 1
 * На вход программы подается произвольный файл, необходимо извлечь из него все ір адреса. В файле могут встречаться ка IPv4 так и Ір6 адреса например, 127.0.0.1 или fe80:0:0:0:200:f8ff:fe21:67cf  Отсортировать ір адреса по возрастанию (сначала IPv4, затем IPv6). Сохранить результат в файл.
 * @autor Бабаскин Никита
 */


public class Main {
    public static void main(String[] args) {
        String inputFileName = "IP";
        String outputFileName = "Zapis";
        ArrayList<String> ipList = readIpAddresses(inputFileName);// читаем IP-адреса из файла
        Collections.sort(ipList);// сортируем IP-адреса
        writeIpAddresses(outputFileName, ipList); // записываем отсортированные IP-адреса в файл
    }

    public static ArrayList<String> readIpAddresses(String fileName) {
        ArrayList<String> ipList = new ArrayList<>();// создаем новый список для IP-адресов
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { // открываем файл для чтения
            String line;
            while ((line = reader.readLine()) != null) { // читаем файл построчно
                String[] words = line.split("\\s");
                for (String word : words) {
                    if (isIPv4(word) || isIPv6(word)) { // проверяем, является ли текущее слово IP-адресом (IPv4 или IPv6)
                        ipList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ipList;  // возвращаем список IP-адресовe
    }

    public static boolean isIPv4(String ip) {
        String[] octets = ip.split("\\.");
        if (octets.length != 4) {
            return false;
        }
        for (String octet : octets) {
            try {
                int value = Integer.parseInt(octet);
                if (value < 0 || value > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true; // если все проверки пройдены успешно, значит это IPv4-адрес
    }

    public static boolean isIPv6(String ip) {
        int colonCount = 0; // счетчик двоеточий в IPv6-адресе
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == ':') {
                colonCount++; // увеличиваем счетчик, если встречаем двоеточие
            }
        }
        if (colonCount < 2 || colonCount > 7) { // если двоеточий меньше 2 или больше 7, значит это не IPv6-адрес
            return false;
        }
        String[] hexDigits = ip.split(":"); // разбиваем строку на hex-цифры
        if (hexDigits.length < 3 || hexDigits.length > 8) {  // если hex-цифр меньше 3 или больше 8, значит это не IPv6-адрес
            return false;
        }
        for (String hexDigit : hexDigits) {  // проверяем каждую hex-цифру
            if (hexDigit.length() == 0 || hexDigit.length() > 4) { // если длина hex-цифры равна 0 или больше 4, значит это не IPv6-адрес
                return false;
            }
            for (int i = 0; i < hexDigit.length(); i++) {  // проверяем каждый символ в hex-цифре
                char c = hexDigit.charAt(i);
                if (!Character.isDigit(c) && (c < 'A' || c > 'F') && (c < 'a' || c > 'f')) {
                    return false;
                }
            }
        }
        return true; // если все проверки пройдены успешно, значит это IPv6-адрес
    }

    public static void writeIpAddresses(String fileName, ArrayList<String> ipList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) { // открываем файл для записи
            for (String ip : ipList) { // записываем каждый IP-адрес из списка
                writer.write(ip);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
