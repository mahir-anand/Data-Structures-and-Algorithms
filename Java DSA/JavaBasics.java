public class JavaBasics {

    public static boolean sodokuSolver (int sodoku[][], int row, int col) {
        //base case
        if (row > 8) {
            return true;
        }
        //recursion
        int newRow = row, newCol = col + 1;
        if (newCol > 8) {
            newRow++;
            newCol = 0;
        }

        if (sodoku[row][col] != 0) {
            return sodokuSolver(sodoku, newRow, newCol);
        }

        for (int num = 1 ; num < 10 ; num++) {
            if (isSafe (sodoku,row,col,num)) {
                sodoku[row][col] = num;
                if (sodokuSolver(sodoku, newRow, newCol)) {
                    return true;
                }
                sodoku[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe (int board[][], int row, int col, int num) {
        //row
        for (int i = 0 ; i < 9 ; i++) {
            if (board [row][i] == num) {
                return false;
            }
        }

        //col
        for (int i = 0 ; i < 9 ; i++) {
            if (board [i][col] == num) {
                return false;
            }
        }

        //grid
        int sr = (row/3) * 3, sc = (col/3) * 3;
        for (int i = sr ; i < sr + 3 ; i++) {
            for (int j = sc ; j < sc + 3 ; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
        
    }

    public static void printBoard (int board [][]) {
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board.length ; j++) {
                System.out.print(board[i][j] + " ");
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

        if (sodokuSolver(sodoku,0,0)) {
            printBoard(sodoku);
        } else {
            System.out.println("No solution to this sodoku board");
        }

    }   

}