import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        double formula, final_formula, answer; // создаём переменные, в которых будем хранить формулу для расчёта и выводить ответ
        int symbol = 3; // создаём переменную, которая хранит в себе значение необходимых нам символов после запятой

        Scanner coordinate = new Scanner(System.in); // сканнер, с помощью которого будем получать инфу
        coordinate.useLocale(Locale.UK);

        final double EARTH_RADIUS = 6371.008; // константа соджержащая радиус земли

        System.out.println("\nДОБРО ПОЖАЛОВАТЬ В ПРОГРАММУ ДЛЯ РАСЧЁТА РАССТОЯНИЯ МЕЖДУ ДВУМЯ ТОЧКАМИ НА ЗЕМНОЙ ПОВЕРХНОСТИ!\n"); // приветствуем пользователя

        while (true){
            System.out.println("Задайте координаты первой точки..."); // выводим пользователю указания к действию и принимаем в переменные данные полученные от пользователя
            System.out.print("Долгота: ");
            double longitude_1 = coordinate.nextDouble(); // получаем данные от пользователя
            System.out.print("Широта: ");
            double width_1 = coordinate.nextDouble();
            System.out.println("\nЗадайте координаты второй точки...");
            System.out.print("Долгота: ");
            double longitude_2 = coordinate.nextDouble();
            System.out.print("Широта: ");
            double width_2 = coordinate.nextDouble();

            double dlon = Math.toRadians(longitude_2 - longitude_1);
            double dwid = Math.toRadians(width_2 - width_1);

            formula = Math.sin(dwid) / 2 * Math.sin(dwid) / 2
                    + Math.cos(Math.toRadians(width_1)) * Math.cos(Math.toRadians(width_2)) * Math.sin(dlon / 2) * Math.sin(dlon / 2);

            final_formula = (2 * Math.atan2(Math.sqrt(formula), Math.sqrt(1 - formula))) * EARTH_RADIUS; // переменная, которая хранит в себе формулу для расчёта

            BigDecimal after_comma = new BigDecimal(final_formula); // используем класс BigDecimal для того, чтобы округлить наш результат до определенного кол-ва символов после точки
            after_comma = after_comma.setScale(symbol, RoundingMode.HALF_UP); // RoundingMode.HALF_UP - округление в большую сторону, если число после точки >= .5
            answer = after_comma.doubleValue();

            System.out.println("\nОтвет: " + answer + " km"); // выводим ответ

            System.out.println("\nПродолжить - 1, если Вы хотите завершить программу, нажмите любой символ...");
            var escape = new Scanner(System.in).nextLine(); /* создаём новую переменную типа сканнер,
            чтобы принимать в неё выбор пользователя остаться в программе или выйти,
            потом с помощью оператора switch задаём значение, при которой программа продолжит работу или закончит*/

            switch (escape){
                case "1":
                    System.out.println(" ");
                    continue;
                default:
                    System.exit(0);
            }
        }
    }
}