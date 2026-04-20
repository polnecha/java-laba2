package fixed;

import java.util.Objects;


/**
 * Сущность линии на двумерной плоскости.
 */
public class Line {

    /** Начальная точка линии. */
    private Point start;

    /** Конечная точка линии. */
    private Point end;

    /**
     * Создаёт линию по двум точкам.
     * @param start начальная точка
     * @param end конечная точка
     */
    public Line(final Point start, final Point end) {
        this.start = Objects.requireNonNull(
                start, "начальная точка не может быть null");
        this.end = Objects.requireNonNull(
                end, "конечная точка не может быть null");
    }

    /**
     * Возвращает начальную точку.
     * @return точка начала
     */
    public Point getStart() {
        return start;
    }

    /**
     * Устанавливает начальную точку.
     * @param start новая начальная точка
     */
    public void setStart(final Point start) {
        this.start = Objects.requireNonNull(
                start, "начальная точка не может быть null");
    }

    /**
     * Возвращает конечную точку.
     * @return точка конца
     */
    public Point getEnd() {
        return end;
    }

    /**
     * Устанавливает конечную точку.
     * @param end новая конечная точка
     */
    public void setEnd(final Point end) {
        this.end = Objects.requireNonNull(
                end, "конечная точка не может быть null");
    }

    /**
     * Возвращает строковое представление линии.
     * @return строка вида "Линия от {X1;Y1} до {X2;Y2}"
     */
    @Override
    public String toString() {
        return "Линия от "
                + start.toString()
                + " до "
                + end.toString();
    }
}