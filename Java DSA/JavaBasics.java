public class JavaBasics {

    public static void search(int matrix[][], int key) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > key) {
                row--;
            } else if (matrix[row][col] < key) {
                col++;
            } else {
                System.out.println("Row is : " + row);
                System.out.println("Col is : " + col);
                break;
            }
        }
    }
  
    public static void main (String args[]) {
        int matrix[][] = { {1,2,3,4},
                           {5,6,7,8},
                           {9,10,11,12},
                           {13,14,15,16}};
        search(matrix, 15);
    }
}