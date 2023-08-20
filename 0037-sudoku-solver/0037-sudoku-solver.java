class Solution {
    public void solveSudoku(char[][] board) {
        if (board.length == 0) {
            return;
        }
        
        sudoku (board,0,0);
    }
    
    public boolean sudoku (char[][] board, int row, int col) {

        if (row >= board.length) {
            // printBoard(board);
            return true;
        }

        int nc = 0, nr = 0;

        if (col == board.length - 1) {
            nr = row + 1;
            nc = 0;
        } else {
            nc = col + 1;
            nr = row;
        }

        if (board[row][col] == '.') {
            for (int i = 1; i <= 9 ; i++) {
                    if (isValid(board,row,col,i)) {
                        board[row][col] = (char)('0' + i);
                        if (sudoku(board, nr, nc)) {
                            return true;
                        } else {
                            board[row][col] = '.';    
                        }
                        
                    }
                }   
        } else {
            return sudoku(board, nr, nc);
        }
        
    return false;
    
    }

    public static boolean isValid (char[][] board, int row, int col, int num) {

        //checking the row
        for (int i = 0 ; i < 9 ; i++) {
            if (Character.getNumericValue(board[row][i]) == num) {
                return false;
            }
        }

        //checking the column
        for (int i = 0 ; i < 9 ; i++) {
            if (Character.getNumericValue(board[i][col]) == num) {
                return false;
            }
        }

        //check the mini square
        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;

        for (int i = startRow ; i <= startRow + 2; i++) {
            for (int j = startCol ; j <= startCol + 2; j++) {
                if (Character.getNumericValue(board[i][j]) == num) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void printBoard (char[][] ans) {

        for (int i = 0 ; i < ans.length ; i++) {
            for (int j = 0 ; j < ans.length ; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }
}