import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);
    // Ввод строки
    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Ввод целого числа с проверкой
    public static int readInt(String message) {
        int value;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // очищаем буфер
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.nextLine();
            }
        }
        return value;
    }

    // Ввод массива оценок
    public static int[] readGrades(String message) {
        System.out.print(message);
        String line = scanner.nextLine();
        String[] tokens = line.split("[,\\s]+"); // разделители: пробел или запятая
        int[] grades = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                grades[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                System.out.println("Некорректная оценка, присваиваем 0.");
                grades[i] = 0;
            }
        }
        return grades;
    }
}
