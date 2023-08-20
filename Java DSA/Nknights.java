public class Nknights {

    public static void nknights (int n, int row, int col, int knights, String[][] ans) {

        if (knights == 0) {
            printMatrix (ans);
            return;
        }

        if (col == n) {
            nknights(n, row+1, 0, knights, ans);
            return;
        }

        if (row >=n) {
            return;
        }

        if (isSafe(n, row, col, ans)) {

            ans[row][col] = "K";
            knights--;

            nknights(n, row, col+1, knights, ans);

            ans[row][col] = ".";
            knights++;
        }

        nknights(n, row, col+1, knights, ans);
    }

    public static boolean isSafe (int n, int row, int col, String[][] ans) {

        if (row-2 >=0 && col-1 >= 0 && ans[row-2][col-1] == "K") {
            return false;
        }

        if (row-2 >=0 && col+1 < n && ans[row-2][col+1] == "K") {
            return false;
        }

        if (row-1 >=0 && col-2 >= 0 && ans[row-1][col-2] == "K") {
            return false;
        }

        if (row-1 >=0 && col+2 < n && ans[row-1][col+2] == "K") {
            return false;
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
        nknights(n, 0, 0, n, ans);
    }
    
}
