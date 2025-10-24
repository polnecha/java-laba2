public class Main {
    public static void main(String[] args) {
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

        // Линия 3 зависит от линии 1 и линии 2
        Line line3 = new Line(line1.getStart(), line2.getEnd());

        System.out.println("\nЛинии:");
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);

        // Ввод студентов
        System.out.println("\nСоздание студентов:");
        Student student1 = new Student(
                InputUtils.readString("Введите имя студента 1: "),
                InputUtils.readGrades("Введите оценки студента 1 через пробел или запятую: ")
        );

        Student student2 = new Student(
                InputUtils.readString("Введите имя студента 2: "),
                InputUtils.readGrades("Введите оценки студента 2 через пробел или запятую: ")
        );

        System.out.println("\nСтуденты:");
        System.out.println(student1);
        System.out.println(student2);

        // Средний балл и отличники
        System.out.println("\nСредний балл и отличники:");
        System.out.println(student1.getName() + " средний: " + student1.average() + ", отличник: " + student1.isExcellent());
        System.out.println(student2.getName() + " средний: " + student2.average() + ", отличник: " + student2.isExcellent());
    }
}
