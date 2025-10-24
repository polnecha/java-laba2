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

        // Линия 3 автоматически создаётся как копия начала линии 1 и конца линии 2
        // Копия точек, чтобы она не зависела от изменений line1 и line2
        Line line3 = new Line(
                new Point(line1.getStart().getX(), line1.getStart().getY()),
                line2.getEnd()
        );

        System.out.println("\nЛинии после создания:");
        System.out.println("Линия 1: " + line1);
        System.out.println("Линия 2: " + line2);
        System.out.println("Линия 3 (копия, независимая): " + line3);

        // Изменяем линию 1 и линию 2
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
