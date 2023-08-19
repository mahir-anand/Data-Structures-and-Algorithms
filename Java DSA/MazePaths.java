public class MazePaths {

    public static int maze (int len, int row, int col) {

        if (col == len - 1 || row == len - 1) {
            return 1;
        }

        int count = 0;

        count = count + maze (len, row, col + 1);
        count = count + maze (len, row + 1, col);
        count = count + maze (len, row + 1, col + 1);

        return count;
    }

    public static void mazePaths (int len, int row, int col, String ans) {

        if (row == len - 1 && col == len - 1) {
            System.out.println(ans);
            return;
        }

        if (col == len - 1) {
            mazePaths (len, row + 1, col, ans + "D");
            return;
        }

        if (row == len - 1) {
            mazePaths (len, row, col + 1, ans + "R");
            return;
        }

        mazePaths (len, row, col + 1, ans + "R");
        mazePaths (len, row + 1, col, ans + "D");

    }

    public static void mazePathsDiagonal (int len, int row, int col, String ans) {

        if (row == len - 1 && col == len - 1) {
            System.out.println(ans);
            return;
        }

        if (col == len - 1) {
            mazePathsDiagonal (len, row + 1, col, ans + "D");
            return;
        }

        if (row == len - 1) {
            mazePathsDiagonal (len, row, col + 1, ans + "R");
            return;
        }

        mazePathsDiagonal (len, row, col + 1, ans + "R");
        mazePathsDiagonal (len, row + 1, col, ans + "D");
        mazePathsDiagonal (len, row + 1, col + 1, ans + "C" );

    }

    public static void mazePathsObstacle (int[][] arr, int len, int row, int col, String ans) {

        // reached the end
        if (row == len - 1 && col == len - 1) {
            System.out.println(ans);
            return;
        }

        //found an obstacle
        if (arr [row][col] == 1) {
            return;
        }

        //last column
        if (col == len - 1) {
            mazePathsObstacle (arr, len, row + 1, col, ans + "D");
            return;
        }

        //last row
        if (row == len - 1) {
            mazePathsObstacle (arr, len, row, col + 1, ans + "R");
            return;
        }


        mazePathsObstacle (arr,len, row, col + 1, ans + "R");
        mazePathsObstacle (arr,len, row + 1, col, ans + "D");

    }

    public static void allPaths (boolean[][] arr, int row, int col, String ans) {

        if (row == arr.length - 1 && col == arr.length-1) {
            System.out.println(ans);
            return;
        }

        if (arr[row][col] != false) {
            arr[row][col] = false;
        } else {
            return;
        }

        if (row < arr.length - 1) {
            allPaths (arr, row + 1, col, ans + "D");
        }
        
        if (col < arr[0].length - 1) {
            allPaths (arr, row, col + 1, ans + "R");
        }
        
        if (row > 0) {
            allPaths (arr, row - 1, col, ans + "U");
        }

        if (col > 0) {
             allPaths (arr, row, col - 1, ans + "L");
        }

        arr[row][col] = true;
        
    }

    public static void allPaths (boolean[][] arr, int row, int col, int[][] ans, int step) {

        step++;

        if (row == arr.length - 1 && col == arr.length-1) {
            ans[row][col] = step;
            printMatrix(ans);
            return;
        }

        if (arr[row][col] != false) {
            arr[row][col] = false;
        } else {
            return;
        }

        ans[row][col] = step;

        if (row < arr.length - 1) {
            allPaths (arr, row + 1, col, ans, step);
        }
        
        if (col < arr[0].length - 1) {
            allPaths (arr, row, col + 1, ans, step);
        }
        
        if (row > 0) {
            allPaths (arr, row - 1, col, ans, step);
        }

        if (col > 0) {
            allPaths (arr, row, col - 1, ans, step);
        }

        arr[row][col] = true;
        ans[row][col] = 0;
        step--;
        
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = 0 ; j < arr[0].length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main (String args[]) {
        boolean[][] arr = { {true,true,true},
                            {true,true,true},
                            {true,true,true}};
        int[][] ans = { {0,0,0},
                      {0,0,0},
                      {0,0,0}};
        allPaths (arr,0,0,ans,0);
        // System.out.println("Total Paths : " + maze(3, 0, 0));
    }
    
}
