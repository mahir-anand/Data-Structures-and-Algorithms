public class JavaBasics {

    public static boolean sodokuSolver (int sodoku[][], int row, int col) {
        //base case
        if (row == 8 && col == 8) {
            return true;
        } else if (row == 8) {
            return false;
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
    }

}