package cz.martin.spirala;

public class Main {
    private static int num = 5;
    private static int[][] field = new int[num][num];
    public static void main(String[] args) {
        // 1  2  3  4
        // 12 13 14 5
        // 11 16 15 6
        // 10 9  8  7

        int border = 0;
        int x = -1;
        int y = 0;
        int direction = 0;
        // 0 - leva
        // 1 - dolu
        // 2 - prava
        // 3 - nahoru

        for (int i = 0; i < field.length * field[0].length; i++) {
            if(direction % 4 == 0) x++;
            else if(direction % 4 == 1) y++;
            else if(direction % 4 == 2) x--;
            else if(direction % 4 == 3) y--;

            field[y][x] = i;

            if((x <= border &&  direction % 4 == 2)|| (y <= border &&  direction % 4 == 3) || (y+1 >= num - border && direction % 4 == 1) || (x+1 >= num - border && direction % 4 == 0)) {
                direction++;
                if(direction % 4 == 3) {
                    border += 1;
                }
            }

        }
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            for (int i1 : field[i]) {
                System.out.print("\t"+i1);
            }
            System.out.println();
        }

    }
}
