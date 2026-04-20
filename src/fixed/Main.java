package fixed;


/**
 * Точка входа в программу.
 */
public final class Main {

    /** Приватный конструктор — класс не должен инстанциироваться. */
    private Main() {
        // утилитный класс
    }

    /**
     * Главная точка входа.
     * @param args аргументы командной строки
     */
    public static void main(final String[] args) {
        while (true) {
            printMenu();
            final int choice = InputUtils.readInt(
                    "выберите пункт меню: ");
            try {
                handleChoice(choice);
            } catch (final Exception e) {
                System.out.println(
                        "ошибка выполнения: " + e.getMessage());
            }
        }
    }

    /**
     * Выводит меню программы.
     */
    private static void printMenu() {
        System.out.println("\n        меню        ");
        System.out.println("1. работа с точками и линиями");
        System.out.println("2. работа со студентами");
        System.out.println("0. выход");
    }

    /**
     * Обрабатывает выбор пользователя.
     * @param choice номер пункта меню
     */
    private static void handleChoice(final int choice) {
        switch (choice) {
            case 1:
                runPointsAndLinesTask();
                break;
            case 2:
                runStudentsTask();
                break;
            case 0:
                System.out.println("выход из программы...");
                InputUtils.close();
                System.exit(0);
                break;
            default:
                System.out.println(
                        "ошибка! нет такого пункта меню.");
        }
    }

    /**
     * Запускает задачу с точками и линиями.
     */
    private static void runPointsAndLinesTask() {
        System.out.println("создание точек:");
        final Point p1 = createPoint("1");
        final Point p2 = createPoint("2");
        final Point p3 = createPoint("3");
        System.out.println("\nточки:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("\nсоздание линий:");
        final Line line1 = createLine("1");
        final Line line2 = createLine("2");
        final Line line3 = new Line(
                new Point(
                        line1.getStart().getX(),
                        line1.getStart().getY()),
                line2.getEnd());

        System.out.println("\nлинии после создания:");
        System.out.println("линия 1: " + line1);
        System.out.println("линия 2: " + line2);
        System.out.println("линия 3: " + line3);

        System.out.println("\nизменяем линии 1 и 2:");
        modifyLine(line1, "1");
        modifyLine(line2, "2");

        System.out.println("\nлинии после изменений:");
        System.out.println("линия 1: " + line1);
        System.out.println("линия 2: " + line2);
        System.out.println("линия 3: " + line3);
    }

    /**
     * Создаёт точку с вводом координат.
     * @param label метка точки для вывода
     * @return новая точка
     */
    private static Point createPoint(final String label) {
        final int x = InputUtils.readInt(
                "введите x для точки " + label + ": ");
        final int y = InputUtils.readInt(
                "введите y для точки " + label + ": ");
        return new Point(x, y);
    }

    /**
     * Создаёт линию с вводом координат.
     * @param label метка линии для вывода
     * @return новая линия
     */
    private static Line createLine(final String label) {
        System.out.println("линия " + label + " — начало:");
        final Point start = createPoint("");
        System.out.println("линия " + label + " — конец:");
        final Point end = createPoint("");
        return new Line(start, end);
    }

    /**
     * Изменяет координаты линии через ввод.
     * @param line линия для изменения
     * @param label метка для вывода
     */
    private static void modifyLine(
            final Line line, final String label) {
        System.out.println(
                "новое начало линии " + label + ":");
        final Point newStart = createPoint("");
        line.setStart(newStart);
        System.out.println(
                "новый конец линии " + label + ":");
        final Point newEnd = createPoint("");
        line.setEnd(newEnd);
    }

    /**
     * Запускает задачу со студентами.
     */
    private static void runStudentsTask() {
        System.out.println("создание студентов:");
        final String name1 = InputUtils.readName(
                "введите имя студента 1: ");
        final int[] grades1 = InputUtils.readGrades(
                "оценки студента 1 (через пробел/запятую): ");
        final Student vasya = new Student(name1, grades1);

        final String name2 = InputUtils.readName(
                "введите имя студента 2: ");
        final Student petya = new Student(name2);
        // ⚠️ присваиваем ссылку — демонстрация проблемы
        petya.setGrades(vasya.getGrades());
        if (petya.getGrades().length > 0) {
            petya.getGrades()[0] = 5;
        }

        System.out.println(
                "\nпосле изменения первой оценки пети:");
        System.out.println(vasya);
        System.out.println(petya);

        final String name3 = InputUtils.readName(
                "введите имя студента 3: ");
        final Student andrey = new Student(name3);
        // ✅ безопасное копирование
        andrey.setGradesCopy(vasya.getGrades());

        if (vasya.getGrades().length > 1) {
            vasya.getGrades()[1] = 2;
        }

        final String name4 = InputUtils.readName(
                "введите имя студента 4: ");
        final int[] grades4 = InputUtils.readGrades(
                "оценки студента 4 (через пробел/запятую): ");
        final Student maksim = new Student(name4, grades4);

        System.out.println(
                "\nпосле изменения второй оценки васи:");
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(andrey);
        System.out.println(maksim);

        printStudentInfo(vasya);
        printStudentInfo(petya);
        printStudentInfo(andrey);
        printStudentInfo(maksim);
    }

    /**
     * Выводит подробную информацию о студенте.
     * @param student студент для вывода
     */
    private static void printStudentInfo(final Student student) {
        System.out.println("\n" + student);
        System.out.printf("средний балл: %.2f%n",
                student.average());
        final String excellent = student.isExcellent()
                ? "да" : "нет";
        System.out.println("отличник: " + excellent);
    }
}
