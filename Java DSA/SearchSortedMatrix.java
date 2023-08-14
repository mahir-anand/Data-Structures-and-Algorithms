public class SearchSortedMatrix {

    public static void search (int matrix[][], int target) {
        int col = 0, row = matrix.length - 1;
        while (row >= 0 && col < matrix.length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                System.out.print(row + " ");
                System.out.print(col + " ");
                return;
            }
        }
        System.out.println("not found");
    }
    public static void main (String args[]) {
        int matrix [][] = { {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16} };
        search(matrix, 11);
    }
    
}
