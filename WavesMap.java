import java.util.ArrayList;

public class WavesMap {

    int[][] map;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BKYELLOW = "\u001B[43m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BKRED = "\u001B[41m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BKBLUE = "\u001B[44m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BKGREEN = "\u001B[42m";

    public void CreateMap() {
        int[][] map = {
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1 },
                { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1 },
                { -1,  0,  0, -1,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0, -1 },
                { -1,  0,  0, -1,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0, -1 },
                { -1,  0,  0, -1,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0, -1 },
                { -1,  0,  0, -1,  0,  0, -1, -1, -1, -1, -1,  0,  0,  0, -1 },
                { -1,  0,  0, -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1 },
                { -1,  0,  0, -1,  0,  0,  0,  0,  0,  0,  0, -1,  0,  0, -1 },
                { -1,  0,  0, -1, -1, -1, -1, -1,  0,  0,  0, -1,  0,  0, -1 },
                { -1,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0, -1,  0,  0, -1 },
                { -1,  0,  0,  0,  0,  0,  0, -1,  0,  0,  0, -1,  0,  0, -1 },
                { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1,  0,  0, -1 },
                { -1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
        };

        this.map = map;
    }

    public boolean isEmpty(Point2d a) {
        return this.map[a.getY()][a.getX()] == 0;
    }

    public boolean isBorder(Point2d a) {
        return this.map[a.getY()][a.getX()] == -1;
    }

    public void SetStartPoint(Point2d a) {
        this.SetPoint(a, -2);
    }

    public boolean isStart(Point2d a) {
        return this.map[a.getY()][a.getX()] == -2;
    }

    public void SetEndPoint(Point2d a) {
        this.SetPoint(a, -3);
    }

    public boolean isEnd(Point2d a) {
        return this.map[a.getY()][a.getX()] == -3;
    }

    public void SetPoint(Point2d a, int value) {
        map[a.getY()][a.getX()] = value;
    }

    public int GetPoint(Point2d a) {
        return this.map[a.getY()][a.getX()];
    }

    /**
     * Печать карты с маршрутом
     * @param road - список точек маршрута
     */
    public void PrintMap(ArrayList<Point2d> road) {
        Point2d pt = new Point2d(0,0);
        int x = 0, y = 0;
        for (int[] is : map) {
            x = 0;
            for (int i : is) {
                switch(i){
                    case -1:
                        System.out.printf(ANSI_BKBLUE + "%s" + ANSI_RESET, "  ");
                        break;
                    case 0:
                        System.out.printf("%s", "  ");
                        break;
                    case -2:
                        System.out.printf(ANSI_BKGREEN + "%s" + ANSI_RESET, "SS");
                        break;
                    case -3:
                        System.out.printf(ANSI_BKRED + "%s" + ANSI_RESET, "EE");
                        break;
                    case -4:
                        System.out.printf(ANSI_BKRED + "%s" + ANSI_RESET, "OO");
                        break;
                    default:
                        pt.setX(x);
                        pt.setY(y);
                        int flag = 0;
                        for (Point2d point : road) {
                            if(point.equals(pt)) {
                                System.out.printf(ANSI_BKYELLOW + "%2d" + ANSI_RESET, i);
                                flag = 1;
                            }
                        }
                        if(flag == 0) 
                            System.out.printf("%2d", i);
                        break;
                }
                x ++;
            }
            System.out.println();
            y ++;
        }
    }
}

