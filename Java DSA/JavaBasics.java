public class JavaBasics {

  public static void printSpiral(int matrix[][]) {
    int startCol = 0;
    int startRow = 0;
    int endCol = matrix[0].length - 1;
    int endRow = matrix.length - 1;
    
    while(startRow <= endRow && startCol <= endCol) {
        // top boundary
        for (int i = startCol ; i <= endCol ; i++) {
            System.out.print(matrix [startRow][i] + " ");
        }

        // right boundary
        for (int i = startRow + 1 ; i <= endCol ; i++) {
            System.out.print(matrix [i][endCol] + " ");
        }

        // bottom boundary
        for (int i = endCol - 1 ; i >= startCol ; i--) {
            if (endRow == startRow) {
                break;
            }
            System.out.print(matrix [endRow][i] + " ");
        }

        // left boundary
        for (int i = endRow - 1 ; i > startRow ; i--) {
            if (endCol == startCol) {
                break;
            }
            System.out.print(matrix [i][startCol] + " ");
        }
        
        startRow ++;
        startCol ++;
        endRow --;
        endCol --;
    }
  }
    public static void main (String args[]) {
        int matrix[][] = { {1,2,3,4},
                           {5,6,7,8},
                           {9,10,11,12},
                           {13,14,15,16}};
        printSpiral(matrix);
    }
}