public class JavaBasics {

    public static boolean nQueens (char board[][], int row) {
        //base case
        if (row == board.length) {
            printBoard(board);
            // count++;
            return true;
        }
        //recursion
        for (int j = 0 ; j < board.length ; j++) {
            if (isSafe (board,row,j)) {
                board [row][j] = 'Q';
                if (nQueens(board, row+1)) {
                    return true;
                }
            }
            board[row][j] = '.';
        }
        return false;
    }

    public static boolean isSafe (char board[][], int row, int col) {
        // vertically up
        for (int i = row - 1 ; i >=0 ; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonally left
        for (int i = row -1 , j = col - 1 ; i >= 0 && j >=0 ; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diagonally right
        for (int i = row -1 , j = col + 1 ; i >= 0 && j < board.length ; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void printBoard (char board[][]) {
        System.out.println("---------chess board---------");
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board.length ; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;
    public static void main (String args[]) {
        //initializing board
        int n = 5;
        char board[][] = new char[n][n];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                board [i][j] = '.';
            }
        }
        nQueens(board, 0);
    }

}