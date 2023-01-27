public class JavaBasics {

    public static int uniquePath(int n, int m, int row, int col) {
        //base case
        if (row == n-1 && col == m-1) {
            return 1;
        } else if (row == n || col == m) {
            return 0;
        }
        //recursion
        int down = uniquePath(n, m, row+1, col); // down
        int right = uniquePath(n, m, row, col+1); // right
        return down + right;
    }
    public static void main (String args[]) {
        int n = 3, m = 5;
        System.out.println(uniquePath(n, m, 0, 0));
    }
    
}