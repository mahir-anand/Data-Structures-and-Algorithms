class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int end = (n * m)  - 1;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (matrix[mid/m][mid%m] > target) {
                end = mid - 1;
            } else if (matrix[mid/m][mid%m] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        
        return false;

        
    }
}