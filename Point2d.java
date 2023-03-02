public class Point2d {
    int x, y;

    public Point2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2d(Point2d a) {
        this.x = a.x;
        this.y = a.y;
    }

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

    /**
     * Получить новую точку со сдвигом x+1
     * @return Point2d
     */
    public Point2d incX() {
        Point2d res = new Point2d(this.x, this.y);
        res.x += 1;
        return res;
    }

    /**
     * Получить новую точку со сдвигом x-1
     * @return
     */
    public Point2d decX() {
        Point2d res = new Point2d(this.x, this.y);
        res.x -= 1;
        return res;
    }

    /**
     * Получить новую точку со сдвигом y+1
     * @return
     */
    public Point2d incY() {
        Point2d res = new Point2d(this.x, this.y);
        res.y += 1;
        return res;
    }

    /**
     * Получить новую точку со сдвигом y-1
     * @return
     */
    public Point2d decY() {
        Point2d res = new Point2d(this.x, this.y);
        res.y -= 1;
        return res;
    }

    public Point2d copy() {
        return this;
    }

    public void prn() {
        System.out.printf("x:%d y:%d\n",x,y);
    }

    public boolean equals(Point2d a) {
        return this.x == a.x && this.y == a.y;
    }
}
