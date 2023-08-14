public class BinarySearchMatrix {
    
    public static void search (int matrix[][], int target) {
        
        int start = 0;
        int n = matrix.length;

        if (n == 0) {
            return;
        }
        
        int m = matrix[0].length;
        int end = (n * m) - 1;

        
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            if (matrix[mid / m][mid % m] > target) {
                end = mid - 1;
            } else if (matrix[mid / m][mid % m] < target) {
                start = mid + 1;
            } else {
                System.out.print(mid / m + " , " + mid % m);
                return;
            }
        }

        System.out.println("Element not found");

    }
    public static void main (String args[]) {
        int matrix [][] = { {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16} };
                            
        search(matrix, 10);
    }
}
