import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;

    // Конструктор: имя + оценки (может быть пустой массив)
    public Student(String name, int... grades) {
        this.name = name;
        if (grades != null) {
            this.grades = Arrays.copyOf(grades, grades.length);
        } else {
            this.grades = new int[0];
        }
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = Arrays.copyOf(grades, grades.length);
    }

    // Средний балл
    public double average() {
        if (grades.length == 0) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.length;
    }

    // Является ли отличником
    public boolean isExcellent() {
        if (grades.length == 0) return false;
        for (int g : grades) {
            if (g < 5) return false;
        }
        return true;
    }

    // Текстовое представление студента
    @Override
    public String toString() {
        return name + ": " + Arrays.toString(grades);
    }
}
