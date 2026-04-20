package fixed;

import java.util.Objects;


/**
 * Сущность точки на двумерной плоскости.
 */
public class Point {

    /** Координата x. */
    private final int x;

    /** Координата y. */
    private final int y;

    /**
     * Создаёт точку с указанными координатами.
     * @param x координата по оси x
     * @param y координата по оси y
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает координату x.
     * @return значение x
     */
    public int getX() {
        return x;
    }

    /**
     * Возвращает координату y.
     * @return значение y
     */
    public int getY() {
        return y;
    }

    /**
     * Возвращает строковое представление точки.
     * @return строка вида "{X;Y}"
     */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    /**
     * Сравнивает точки по значениям координат.
     * @param obj другой объект
     * @return true, если координаты совпадают
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    /**
     * Возвращает хеш-код точки.
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}