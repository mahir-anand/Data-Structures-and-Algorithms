public class SpiralMatrix {
    
    public static void spiral (int matrix[][]) {

        int maxCol = matrix[0].length - 1;
        int maxRow = matrix.length - 1;
        int startCol = 0, startRow = 0;

        while (startCol <= maxCol && startRow <= maxRow) {

            for (int i = startCol ; i <= maxCol ; i++) {
                System.out.print(matrix[startRow][i] + " ");
            }

            for (int i = startRow + 1 ; i <= maxRow ; i++) {
                System.out.print(matrix[i][maxCol] + " ");
            }

            for (int i = maxCol - 1 ; i >= startCol ; i--) {
                if (maxRow == startRow) {
                    break;
                }
                System.out.print(matrix[maxRow][i] + " ");
            }

            for (int i = maxRow - 1 ; i >= startRow + 1 ; i--) {
                if (maxCol == startCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            maxRow--;
            maxCol--;

        }

    }
    public static void main (String args[]) {
        int matrix[][] = { {1,2,3,4},
                           {5,6,7,8},
                           {9,10,11,12},
                           {13,14,15,16} };
        spiral(matrix);
    }
}
