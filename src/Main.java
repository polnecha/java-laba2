public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n        МЕНЮ        ");
            System.out.println("1. Работа с точками и линиями");
            System.out.println("2. Работа со студентами");
            System.out.println("0. Выход");

            int choice = InputUtils.readInt("Выберите пункт меню: ");

            switch (choice) {
                case 1 -> runPointsAndLinesTask();
                case 2 -> runStudentsTask();
                case 0 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Ошибка! Нет такого пункта меню.");
            }
        }
    }
    private static void runPointsAndLinesTask() {
        // Ввод точек
        System.out.println("Создание точек:");
        Point p1 = new Point(InputUtils.readInt("Введите X для точки 1: "),
                InputUtils.readInt("Введите Y для точки 1: "));
        Point p2 = new Point(InputUtils.readInt("Введите X для точки 2: "),
                InputUtils.readInt("Введите Y для точки 2: "));
        Point p3 = new Point(InputUtils.readInt("Введите X для точки 3: "),
                InputUtils.readInt("Введите Y для точки 3: "));

        System.out.println("\nТочки:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Ввод линий
        System.out.println("\nСоздание линий:");
        Line line1 = new Line(
                new Point(InputUtils.readInt("Введите X начала линии 1: "),
                        InputUtils.readInt("Введите Y начала линии 1: ")),
                new Point(InputUtils.readInt("Введите X конца линии 1: "),
                        InputUtils.readInt("Введите Y конца линии 1: "))
        );

        Line line2 = new Line(
                new Point(InputUtils.readInt("Введите X начала линии 2: "),
                        InputUtils.readInt("Введите Y начала линии 2: ")),
                new Point(InputUtils.readInt("Введите X конца линии 2: "),
                        InputUtils.readInt("Введите Y конца линии 2: "))
        );

        Line line3 = new Line(
                new Point(line1.getStart().getX(), line1.getStart().getY()),
                line2.getEnd()
        );

        System.out.println("\nЛинии после создания:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3 (копия, независимая): " + line3);

        System.out.println("\nИзменяем линии 1 и 2:");

        line1.getStart().setX(InputUtils.readInt("Введите новое X начала линии 1: "));
        line1.getStart().setY(InputUtils.readInt("Введите новое Y начала линии 1: "));
        line1.getEnd().setX(InputUtils.readInt("Введите новое X конца линии 1: "));
        line1.getEnd().setY(InputUtils.readInt("Введите новое Y конца линии 1: "));

        line2.getStart().setX(InputUtils.readInt("Введите новое X начала линии 2: "));
        line2.getStart().setY(InputUtils.readInt("Введите новое Y начала линии 2: "));
        line2.getEnd().setX(InputUtils.readInt("Введите новое X конца линии 2: "));
        line2.getEnd().setY(InputUtils.readInt("Введите новое Y конца линии 2: "));

        System.out.println("\nЛинии после изменений линий 1 и 2:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3 (не изменилась, остаётся прежней): " + line3);
    }
    private static void runStudentsTask() {
        // Ввод студентов
        System.out.println("Создание студентов:");

        String name1 = InputUtils.readName("Введите имя студента 1: ");
        int[] grades1 = InputUtils.readGrades("Введите оценки студента 1 через пробел или запятую: ");
        Student vasya = new Student(name1, grades1);

        String name2 = InputUtils.readName("Введите имя студента 2: ");
        Student petya = new Student(name2);
        petya.setGrades(vasya.getGrades()); // общий массив оценок

        if (petya.getGrades().length > 0) {
            petya.getGrades()[0] = 5;
        }

        System.out.println("\nПосле изменения первой оценки Пети:");
        System.out.println(vasya);
        System.out.println(petya);
        //System.out.println("У обоих изменилась первая оценка, т.к. оценки общие (по ссылке).");

        String name3 = InputUtils.readName("Введите имя студента 3: ");
        Student andrey = new Student(name3);
        andrey.setGradesCopy(vasya.getGrades());

        // Меняем вторую оценку Васи (для проверки независимости)
        if (vasya.getGrades().length > 1) {
            vasya.getGrades()[1] = 2;
        }

        String name4 = InputUtils.readName("Введите имя студента 4: ");
        int[] grades4 = InputUtils.readGrades("Введите оценки студента 1 через пробел или запятую: ");
        Student maksim = new Student(name4, grades4);

        System.out.println("\nПосле изменения второй оценки Васи:");
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(andrey);
        System.out.println(maksim);
        //System.out.println("У Андрея оценки не изменились, потому что у него своя копия массива.");

        printStudentInfo(vasya);
        printStudentInfo(petya);
        printStudentInfo(andrey);
        printStudentInfo(maksim);
    }
        private static void printStudentInfo(Student student) {
            System.out.println("\n" + student);
            System.out.printf("Средний балл: %.2f%n", student.average());
            System.out.println("Отличник: " + (student.isExcellent() ? "Да" : "Нет"));
    }
}
