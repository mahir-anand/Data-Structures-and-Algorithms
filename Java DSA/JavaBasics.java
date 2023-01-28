public class JavaBasics {

    public static void pathFinder (int maze[][], int solution[][], int row, int col) {
        //base case
        if (row == maze.length - 1 && col == maze.length - 1 && maze[row][col] == 1) {
            solution [row][col] = 1;
            printPath(solution);
            return;
        } else if (row >= maze.length || col >= maze.length) {
            return;
        }

        //recursion 

        //down
        if (row < maze.length - 1 && maze [row++][col] != 0 && solution [row++][col] != 1) {
            row++;
            solution[row][col] = 1;
            pathFinder (maze,solution,row,col);
            solution[row][col] = 0;
            row--;
        }

        //left
        if (col < maze.length -1 && maze [row][col++] != 0 && solution [row][col++] != 1) {
            col++;
            solution[row][col] = 1;
            pathFinder (maze,solution,row,col);
            solution[row][col] = 0;
            col--;
        }

    }

    public static void printPath (int solution[][]) {
        for (int i = 0 ; i < solution.length ; i ++) {
            for (int j = 0 ; j < solution.length ; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main (String args[]) {
    int maze[][] = {
    {1,1,0},
    {1,1,1}, 
    {1,1,1}
   };

    int solution [][] = {{0,0,0},
    {0,0,0},
    {0,0,0}
    };
    pathFinder(maze,solution,0,0);

}

}