public class NQueens {

    public static void nqueens (int n, int row, int col, String[][] ans) {

        if (row == n) {
            printMatrix(ans);
            return;
        }

        for (int i = 0 ; i < n ; i ++) {
            if (isSafe(n,row,i,ans)) {
                ans [row][i] = "Q";
                nqueens(n, row + 1, i, ans);
                ans [row][i] = ".";
            }
        }
    }

    public static boolean isSafe (int n, int row, int col, String[][] ans) {

        int row1 = row, row2 = row, row3 = row;
        int col2 = col, col3 = col;

        while (row1 >= 0) {
            if (ans[row1][col] == "Q") {
                return false;
            }
            row1--;
        }

        while (row2 >= 0 && col2 >= 0) {
            if (ans[row2][col2] == "Q") {
                return false;
            }
            row2--;col2--;
        }

        while (row3 >= 0 && col3 < n) {
            if (ans[row3][col3] == "Q") {
                return false;
            }
            row3--;col3++;
        }

        return true;

    }

    public static void printMatrix (String[][] ans) {
        for (int i = 0 ; i < ans.length ; i++) {
            for (int j = 0 ; j < ans.length ; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main (String args[]) {
        int n = 4;
        String[][] ans = new String[n][n];
        for (int i = 0 ; i < ans.length ; i++) {
            for (int j = 0 ; j < ans.length ; j++) {
                ans[i][j] = ".";
            }
        }
        nqueens(n, 0, 0, ans);
    }
    
}
