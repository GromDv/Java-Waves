import java.util.ArrayList;

public class appWaves {

    static WavesMap wMap = new WavesMap();
    static ArrayList<Point2d> route = new ArrayList<Point2d>();
    static int ccc = 0;

    /**
     * Реализация волнового алгоритма построения маршрута
     * @param args
     */
    public static void main(String[] args) {

        wMap.CreateMap();
        Point2d StartPt = new Point2d(2, 11);
        wMap.SetStartPoint(StartPt);
        Point2d EndPt = new Point2d(12, 4);
        wMap.SetEndPoint(EndPt);

        wMap.PrintMap(route);

        WaveRouting(StartPt, 0);

        FindRoteEndPoint(EndPt);

        System.out.println();
        wMap.PrintMap(route);
     }

    /**
     * Волновой расчет шагов по карте (рекурсия)
     * @param a - стартовая точка
     * @param step - текущий шаг
     */
    public static void WaveRouting(Point2d a, int step) {
        if (wMap.isEmpty(a) || wMap.isStart(a) || wMap.GetPoint(a) > step) {
            if (!wMap.isStart(a)) {
                wMap.SetPoint(a, step);
            }
            WaveRouting(a.incX(), step + 1);
            WaveRouting(a.decY(), step + 1);
            WaveRouting(a.decX(), step + 1);
            WaveRouting(a.incY(), step + 1);
        }
    }
    
    /**
     * Рекурсивное построение списка маршрутных точек начиная с конца
     * @param a - конечная точка маршрута
     */
    public static void FindRoteEndPoint(Point2d a) {
        route.add(a);

        if (wMap.isStart(a))
            return;

        Point2d res = new Point2d(a);

        int tmp = 100;
        Point2d tp1 = a.incX();
        if (!wMap.isBorder(tp1) && !wMap.isEnd(tp1)) {
            tmp = wMap.GetPoint(tp1);
            res = tp1.copy();
        }

        Point2d tp2 = a.incY();
        if (!wMap.isBorder(tp2) && !wMap.isEnd(tp2))
            if (tmp > wMap.GetPoint(tp2)) {
                tmp = wMap.GetPoint(tp2);
                res = tp2.copy();
            }

        Point2d tp3 = a.decX();
        if (!wMap.isBorder(tp3) && !wMap.isEnd(tp3))
            if (tmp > wMap.GetPoint(tp3)) {
                tmp = wMap.GetPoint(tp3);
                res = tp3.copy();
            }

        Point2d tp4 = a.decY();
        if (!wMap.isBorder(tp4) && !wMap.isEnd(tp4))
            if (tmp > wMap.GetPoint(tp4)) {
                tmp = wMap.GetPoint(tp4);
                res = tp4.copy();
            }

        FindRoteEndPoint(res);
    }
}
