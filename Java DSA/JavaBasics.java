public class JavaBasics {

    public static boolean isSafe (int maze[][], int row, int col) {
        return (row < maze.length && col < maze.length && row >= 0 && col >=0 && maze[row][col] != 0);
    }

    public static boolean findPathUtil (int maze[][], int solution[][], int row, int col) {
        //base case
        if (row == maze.length - 1 && col == row && maze[row][col] == 1) {
            solution[row][col] = 1;
            return true;
        }

        //recursion
        if (isSafe(maze, row, col)) {
            solution [row][col] = 1;
            if (findPathUtil(maze, solution, row+1, col) ) {
                return true;
            }

            if (findPathUtil(maze, solution, row, col+1)) {
                return true; 
            }

            solution[row][col] = 0;
            return false;
        }

        return false;
    }

    public static void printArray (int maze[][]) {
        for (int i = 0 ; i < maze.length ; i ++) {
            for (int j = 0 ; j < maze.length ; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findPath (int maze[][]) {
        int solution [][] = new int [maze.length][maze.length];
        if (findPathUtil(maze, solution, 0, 0) ) {
            printArray(solution);
        } else {
            System.out.println("No solution exists");
        }
    }

    public static void main (String args[]) {
        int maze[][] = {{1,1,0,0},
                        {1,1,1,1},
                        {1,1,0,1},
                        {0,1,1,1}};
        int n = maze.length;
        findPath(maze);
    }

}