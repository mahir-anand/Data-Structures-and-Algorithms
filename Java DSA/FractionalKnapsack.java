import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    
    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] weight = {10,20,30};
        int W  = 50;

        double[][] matrix = new double[val.length][2];

        for (int i = 0 ; i < val.length ; i++) {
            matrix[i][0] = i;
            matrix[i][1] = val[i]/(double)weight[i];
        }

        Arrays.sort(matrix, Comparator.comparingDouble(o -> o[1]));

        int ans = 0;
        int capacity = W;

        for (int i = matrix.length - 1 ; i >= 0 ; i--) {
            int idx = (int)matrix[i][0];
            if (capacity >= weight[idx]) {
                ans += val[idx];
                capacity -= weight[idx];
            } else {
                ans += matrix[i][1] * capacity;
                break;
            }
        }

        System.out.println(ans);

    }

}
