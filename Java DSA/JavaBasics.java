public class JavaBasics {

    public static boolean sodokuSolver (int sodoku[][], int row, int col) {
        //base case
        if (row > 8) {
            return true;
        }

        //recursion
        int nextRow = row, nextCol = col + 1;
        if (nextCol > 8) {
            nextRow++;
            nextCol = 0;
        }

        if (sodoku[row][col] != 0) {
            return sodokuSolver(sodoku, nextRow, nextCol);
        }
        for (int i = 1 ; i <=9 ; i++) {
            if (isSafe(sodoku, row, col, i)) {
                sodoku[row][col] = i;
                if (sodokuSolver(sodoku, nextRow, nextCol)) {
                    return true;
                }
                sodoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe (int sodoku[][], int row, int col, int num) {
        //row
        for (int j = 0 ; j < sodoku.length ; j++) {
            if (sodoku[row][j] == num) {
                return false;
            }
        }

        //col
        for (int i = 0 ; i < sodoku.length ; i++) {
            if (sodoku[i][col] == num) {
                return false;
            }
        }

        //grid
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;
        for (int i = 0 ; i < startRow + 3 ; i++) {
            for (int j = 0 ; j < startCol + 3 ; j++) {
                if (sodoku[startRow][startCol] == num) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void printSodoku(int sodoku[][]) {
        for (int i = 0 ; i < 9 ; i ++) {
            for (int j = 0 ; j < 9 ; j++) {
                System.out.print(sodoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main (String args[]) {
        int sodoku[][] = { {0,0,8,0,0,0,0,0,0} ,
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0,},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3} };
    

        if (sodokuSolver (sodoku,0,0)) {
            printSodoku(sodoku);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}