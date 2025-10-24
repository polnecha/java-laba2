public class Point {
    private int x;
    private int y;

    // Конструктор с обязательным указанием обеих координат
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры и сеттеры для координат
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Текстовое представление точки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}