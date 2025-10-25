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

//    public static int readIntOrDefault(String message, int defaultValue) {
//        System.out.print(message);
//        String line = scanner.nextLine();       // читаем строку полностью
//        if (line.isEmpty()) {                   // если пусто
//            return defaultValue;                // возвращаем значение по умолчанию
//        }
//        try {
//            return Integer.parseInt(line);      // преобразуем строку в число
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка! Введите целое число.");
//            return readIntOrDefault(message, defaultValue); // повторяем ввод
//        }
//    }
    // Ввод массива оценок
    public static int[] readGrades(String message) {
        System.out.print(message);
        String line = scanner.nextLine().trim(); // убираем лишние пробелы

        if (line.isEmpty()) {
            return new int[0];
        }

        String[] tokens = line.split("[,\\s]+");
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
    // Ввод имени (только буквы)
    public static String readName(String message) {
        String name;
        while (true) {
            System.out.print(message);
            name = scanner.nextLine().trim();

            if (name.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
                return name;
            } else {
                System.out.println("Ошибка! Имя может содержать только буквы. Попробуйте снова.");
            }
        }
    }
}
