package fixed;

import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * Утилиты для ввода данных с клавиатуры.
 */
public final class InputUtils {

    /** Сканер для чтения ввода. */
    private static final Scanner SCANNER = new Scanner(System.in);

    /** Приватный конструктор — класс не должен инстанциироваться. */
    private InputUtils() {
        // утилитный класс
    }

    /**
     * Читает строку с подсказкой.
     * @param message подсказка пользователю
     * @return введённая строка
     */
    public static String readString(final String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }

    /**
     * Читает целое число с проверкой.
     * @param message подсказка пользователю
     * @return введённое число
     */
    public static int readInt(final String message) {
        while (true) {
            try {
                System.out.print(message);
                return SCANNER.nextInt();
            } catch (final InputMismatchException e) {
                System.out.println("ошибка! введите целое число.");
                SCANNER.nextLine(); // очистка буфера
            }
        }
    }

    /**
     * Читает массив оценок из строки.
     * @param message подсказка пользователю
     * @return массив целых чисел
     */
    public static int[] readGrades(final String message) {
        System.out.print(message);
        final String line = SCANNER.nextLine().trim();
        if (line.isEmpty()) {
            return new int[0];
        }
        final String[] tokens = line.split("[,\\s]+");
        final int[] grades = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                grades[i] = Integer.parseInt(tokens[i]);
            } catch (final NumberFormatException e) {
                System.out.println("некорректная оценка, присваиваем 0.");
                grades[i] = 0;
            }
        }
        return grades;
    }

    /**
     * Читает имя (только буквы).
     * @param message подсказка пользователю
     * @return валидное имя
     */
    public static String readName(final String message) {
        while (true) {
            System.out.print(message);
            final String name = SCANNER.nextLine().trim();
            if (name.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
                return name;
            }
            System.out.println(
                    "ошибка! имя может содержать только буквы.");
        }
    }

    /**
     * Закрывает сканер (вызывать при завершении программы).
     */
    public static void close() {
        SCANNER.close();
    }
}
