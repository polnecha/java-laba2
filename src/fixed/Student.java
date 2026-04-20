package fixed;

import java.util.Arrays;
import java.util.Objects;


/**
 * Сущность студента с именем и оценками.
 */
public class Student {

    /** Имя студента. */
    private final String name;

    /** Массив оценок (копия, чтобы избежать утечки ссылки). */
    private int[] grades;

    /**
     * Создаёт студента с именем и опциональными оценками.
     * @param name имя студента
     * @param grades переменное число оценок
     */
    public Student(final String name, final int... grades) {
        this.name = Objects.requireNonNull(
                name, "имя студента не может быть null");
        if (grades != null && grades.length > 0) {
            this.grades = Arrays.copyOf(grades, grades.length);
        } else {
            this.grades = new int[0];
        }
    }

    /**
     * Возвращает имя студента.
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает копию массива оценок.
     * @return копия массива оценок
     */
    public int[] getGrades() {
        return Arrays.copyOf(grades, grades.length);
    }

    /**
     * Устанавливает оценки через присваивание ссылки.
     * ⚠️ не рекомендуется — нарушает инкапсуляцию.
     * @param grades массив оценок
     */
    public void setGrades(final int[] grades) {
        this.grades = grades;
    }

    /**
     * Устанавливает оценки через безопасное копирование.
     * @param grades исходный массив оценок
     */
    public void setGradesCopy(final int[] grades) {
        if (grades != null) {
            this.grades = Arrays.copyOf(grades, grades.length);
        } else {
            this.grades = new int[0];
        }
    }

    /**
     * Вычисляет средний балл.
     * @return среднее арифметическое, 0.0 если оценок нет
     */
    public double average() {
        if (grades.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (final int g : grades) {
            sum += g;
        }
        return (double) sum / grades.length;
    }

    /**
     * Проверяет, является ли студент отличником.
     * @return true, если есть оценки и все равны 5
     */
    public boolean isExcellent() {
        if (grades.length == 0) {
            return false;
        }
        for (final int g : grades) {
            if (g != 5) {
                return false;
            }
        }
        return true;
    }

    /**
     * Возвращает строковое представление студента.
     * @return строка вида "Имя: [оценка1, оценка2, ...]"
     */
    @Override
    public String toString() {
        if (grades.length == 0) {
            return name + ": оценок нет";
        }
        return name + ": " + Arrays.toString(grades);
    }
}
