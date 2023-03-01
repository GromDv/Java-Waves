public class appWaves {

    public static void main(String[] args) {
        
        WavesMap wMap = new WavesMap();

        wMap.CreateMap();
        wMap.SetStartPoint(2, 11);
        wMap.SetEndtPoint(12, 1);
        wMap.PrintMap();
    }
}

