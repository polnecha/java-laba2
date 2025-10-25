# Нечаева Полина ИТ-3,4 Лабораторная №2

# Задание 1
## Задача 1
### Текст задачи
Точка координат.  
Создайте сущность Точка, расположенную на двумерной плоскости, которая описывается:  
• Координата Х: число  
• Координата Y: число  
• Может возвращать текстовое представление вида “{X;Y}”  
Необходимо создать три точки с разными координатами и вывести на экран их текстовое представление.

### Алгоритм решения
**Создание класса Point:**
```java 
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
```
**Пример использования Point:**
```java
public class Main {
    public static void main(String[] args) {
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
    }
}
```
**Вспомогательный класс для ввода и проверки:**
```java
import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

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
}
```
# Задание 2
## Задача 1
### Текст задачи
Прямая.  
Создайте сущность Линия, расположенную на двумерной плоскости, которая описывается: • Координата начала: Точка   
• Координата конца: Точка   
• Может возвращать текстовое представление вида “Линия от {X1;Y1} до {X2;Y2}”   
Для указания координат нужно использовать сущность Точка, разработанную в задании 1.1. Создайте линии со следующими характеристиками:  
1.	Линия 1 с началом в т. {1;3} и концом в т.{23;8}  
2.	 Линия 2, горизонтальная, на высоте 10, от точки 5 до точки 25.   
3.	 Линия 3, которая начинается всегда там же, где начинается линия 1, и заканчивается всегда там же, где заканчивается линия 2. Таким образом, если положение первой или второй линии меняется, то меняется и третья линия  
4.	 После создания всех трех объектов измените координаты первой и второй линий, причем сделайте это таким образом, чтобы положение третьей линии соответствовало требованиям пункта 3.  
5.	Измените координаты первой линии так, чтобы при этом не изменились, координаты третьей линии.  
### Алгоритм решения
**Создание класса Line:**
```java 
public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() { return start; }
    public void setStart(Point start) { this.start = start; }

    public Point getEnd() { return end; }
    public void setEnd(Point end) { this.end = end; }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
```
**Пример использования Line:**
```java
public class Main {
    public static void main(String[] args) {
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
```
# Задание 3
## Задача 1
### Текст задачи
Студент.   
Создайте сущность Студент, которая описывается:  
 • Имя: строка  
 • Оценки: массив целых чисел.  
 • Может возвращать текстовое представление вида “Имя: [оценка1, оценка2,…,оценкаN]” 
Необходимо выполнить следующие задачи:    
 1. Создать студента Васю с оценками: 3,4,5.   
 2. Создать студента Петю и скопировать оценки Васи, присвоив содержимое поля с оценками Васи полю с оценками Пети.  
 3. Заменить первую оценку Пети на число 5. Вывести на экран строковое представление Васи и Пети. Объяснить результат   
4. Создать студента Андрея и скопировать ему оценки Васи так, чтобы изменение оценок Васи не влияло на Андрея.  
### Алгоритм решения  
**Создание класса Student:**
```java
import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;
    
    public Student(String name, int... grades) {
        this.name = name;
        if (grades != null) {
            this.grades = Arrays.copyOf(grades, grades.length);
        } else {
            this.grades = new int[0];
        }
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades; // присваиваем сслыыку
    }

\    public void setGradesCopy(int[] grades) {
        this.grades = Arrays.copyOf(grades, grades.length);
    }

    @Override
    public String toString() {

        return name + ": " + Arrays.toString(grades);
    }
}
```
**Пример использования Student:**
```java
public class Main {
    public static void main(String[] args) {
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
    }
}

```
**Вспомогательный класс для ввода и проверки:**
```java
import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);
    // Ввод строки
    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Ввод массива оценок
    public static int[] readGrades(String message) {
        System.out.print(message);
        String line = scanner.nextLine().trim(); // убираем лишние пробелы

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

```

# Задание 4
## Задача 1
### Текст задачи
Создаем Точку.   
Измените сущность Точка из задачи 1.1. В соответствии с новыми требованиями создать объект Точки можно только путем указания обеих координат:X и Y.
Необходимо выполнить следующие задачи:     
• Создайте и выведите на экран точку с координатами 3;5  
• Создайте и выведите на экран точку с координатами 25;6   
• Создайте и выведите на экран точку с координатами 7;8  
### Алгоритм решения
**Модифицированный InputUtils для значений по умолчанию:**
```java
import java.util.Scanner;

public class InputUtils {
    public static int readIntOrDefault(String message, int defaultValue) {
        System.out.print(message);
        String line = scanner.nextLine();
        if (line.isEmpty()) {                   // если пусто
            return defaultValue;                // возвращаем значение по умолчанию
        }
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Введите целое число.");
            return readIntOrDefault(message, defaultValue);
        }
    }
}
```
**Пример использования Point:**
```java
public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(InputUtils.readIntOrDefault("Введите X для точки 1: ", 0),
                InputUtils.readIntOrDefault("Введите Y для точки 1: ", 0));
        Point p2 = new Point(InputUtils.readIntOrDefault("Введите X для точки 2: ", 0),
                InputUtils.readIntOrDefault("Введите Y для точки 2: ", 0));
        Point p3 = new Point(InputUtils.readIntOrDefault("Введите X для точки 3: ", 0),
                InputUtils.readIntOrDefault("Введите Y для точки 3: ", 0));

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
```
## Задача 7
### Текст задачи
Создаем Студента.   
Измените сущность Студент из задачи 3.1. Новые требования включают:   
• Студента можно создать указав только имя   
• Студента можно создать указав имя и набор оценок   
• Оба способа должны быть реализованы единственным конструктором  
Создайте и выведите на экран следующие объекты:  
1. Студент Вася с оценками: 3,4,5.  
2. Студент Максим без оценок  
### Алгоритм решения
**Добавление 4 студента:**
```java
public class Main {
    public static void main(String[] args) {
        ...
    }
    
    }
    private static void runStudentsTask() {
        ...
        String name4 = InputUtils.readName("Введите имя студента 4: ");
        int[] grades4 = InputUtils.readGrades("Введите оценки студента 1 через пробел или запятую: ");
        Student maksim = new Student(name4, grades4);

        System.out.println(maksim);
        ....
    }
}
```
**Модифицированный InputUtils для студентов без оценок:**
```java
import java.util.Scanner;

public class InputUtils {
    ...

        // Если пользователь просто нажал Enter — возвращаем пустой массив
        if (line.isEmpty()) {
            return new int[0];
        }
    ....
    }
}
```
**Модифицированный Student для студентов без оценок:**
```java
 @Override
    public String toString() {
        if (grades.length == 0) {
            return name + ": оценок нет";
        } else {
            return name + ": " + Arrays.toString(grades);
        }    }
```
# Задание 5
## Задача 6
### Текст задачи
Студент отличник.  
 Измените сущность Студент из задачи 4.7. Новые требования включают:  
• Студент может возвращать значение своей средней оценки (вещественное число). Если оценок нет, то среднее – 0.   
• Студент может возвращать информацию о том, является ли он отличником или нет. Студент является отличником если у него есть хотя бы одна оценка и все оценки только отличные.  
 Необходимо выполнить следующие задачи:   
1. Создайте студента Васю с оценками 3,4,5,4   
2. Создайте студента Петю с оценками 5,5,5,5  
3. Выведите для обоих студентов информацию о среднем балле и являются ли они отличниками  
### Алгоритм решения"
```java
   // Средний балл
    public double average() {
        if (grades.length == 0) return 0.0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.length;
    }

    // Проверка отличник ли студент
    public boolean isExcellent() {
        if (grades.length == 0) return false;
        for (int g : grades) {
            if (g < 5) return false; // если есть хотя бы одна не "5"
        }
        return true;
    }
```