public class Line {
    private Point start;
    private Point end;

    // Конструктор
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Геттеры и сеттеры
    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    // Текстовое представление линии
    @Override
    public String toString() {
        return "Линия от " + start.toString() + " до " + end.toString();
    }
}
