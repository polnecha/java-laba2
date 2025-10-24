public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public static Line copy(Line original) {
        return new Line(
                new Point(original.getStart().getX(), original.getStart().getY()),
                new Point(original.getEnd().getX(), original.getEnd().getY())
        );
    }

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
