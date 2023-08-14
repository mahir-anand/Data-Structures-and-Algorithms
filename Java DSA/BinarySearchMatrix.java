public class BinarySearchMatrix {
    
    public static void search (int matrix[][], int target) {

        int row = 0;

        for (int i = 0 ; i < matrix.length ; i++) {
            if (matrix[i][matrix.length - 1] >= target) {
                row = i;
                break;
            }
        }
        
        int start = 0;
        int end = matrix[row].length - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (matrix[row][mid] > target) {
                end = mid - 1;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                System.out.print(row + " , " + mid);
                break;
            }
        }

    }
    public static void main (String args[]) {
        int matrix [][] = { {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16} };
                            
        search(matrix, 10);
    }
}
