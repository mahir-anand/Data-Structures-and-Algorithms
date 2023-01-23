public class JavaBasics {
    
    public static int gridWays (int i, int j, int n, int m) {
        // base case
        // if (i == n-1 && j == m-1) {
        //     return 1;
        // } else if (i == n || j == m) {
        //     return 0;
        // }
        // //recursion
        // int w1 = gridWays(i+1, j, n, m); //down
        // int w2 = gridWays(i, j+1, n, m); //right
        // return w1 + w2;
        int num = fact (n - 1 + m - 1);
        int den = fact (n-1) * fact (m-1);
        return num/den;
    }

    public static int fact ( int num ) {
        //base case
        if (num == 1) {
            return 1;
        }
        //recursion
        int fact = num * fact (num-1);
        return fact;
    }
    public static void main (String args[]) {
        int n = 4, m = 4;
        System.out.println(gridWays(0, 0, n, m));
    }

}