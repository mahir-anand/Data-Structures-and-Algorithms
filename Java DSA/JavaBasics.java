public class JavaBasics {

    public static boolean isSafe (int solution[][], int row, int col) {
        return (row >= 0 && col >= 0 && row < solution.length && col < solution.length && solution[row][col] == -1);
    }

    public static boolean printTourUtil (int solution[][], int xPath[], int yPath[], int row, int col, int moveCount) {
        //base case
        if (moveCount == 64) {
            return true;
        }
        
        //recursion
        for (int i = 0 ; i < 8 ; i ++) {
            int x = row + xPath[i];
            int y = col + yPath[i];
            

            if (isSafe (solution,x,y)) {
                solution[row][col] = moveCount;
                if (printTourUtil(solution, xPath, yPath, x, y, moveCount+1)) {
                    return true;
                } else {
                    solution[row][col] = -1;
                }
            }
        }
        return false;
    }

    public static void printTour (int solution[][]) {
        int xPath[] = {2,1,-1,-2,-2,-1,1,2};
        int yPath[] = {1,2,2,1,-1,-2,-2,-1};

        solution[0][0] = 0;

        if (printTourUtil(solution, xPath, yPath, 0, 0, 1)) {
            printArray (solution);
        } else {
            System.out.println("No solution");
        }

    }

    public static void printArray (int solution[][]) {
        for (int i = 0 ; i < solution.length ; i++) {
            for (int j = 0 ; j < solution.length ; j++) {
                if (solution[i][j] < 10) {
                    System.out.print(solution[i][j] + "   ");
                } else {
                    System.out.print(solution[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    public static void main (String args[]) {
        int solution[][] = new int[8][8];
        for (int i = 0 ; i < solution.length ; i++) {
            for (int j = 0 ; j < solution.length ; j++) {
                solution [i][j] = -1;
            }
        }

        printTour(solution);

    }

}