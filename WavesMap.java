public class WavesMap {

    int[][] map;

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

    public void SetStartPoint(int x, int y) {
        map[y][x] = -2;
    }

    public void SetEndtPoint(int x, int y) {
        map[y][x] = -3;
    }

    public void PrintMap() {
        for (int[] is : map) {
            for (int i : is) {
                switch(i){
                    case -1:
                        System.out.printf("%s", "⛌");
                        break;
                    case 0:
                        System.out.printf("%s", " ");
                        break;
                    case -2:
                        System.out.printf("%s", "S");
                        break;
                    case -3:
                        System.out.printf("%s", "E");
                        break;
                }
            }
            System.out.println();
        }
    }

}