import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        
        int[][] matrix = new int[start.length][3];
        for (int i = 0 ; i < start.length ; i++) {
            matrix[i][0] = i;
            matrix[i][1] = start[i];
            matrix[i][2] = end[i];
        }

        Arrays.sort(matrix, Comparator.comparingDouble(o -> o[2]));

        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        // adding the first activity
        count = 1;
        ans.add(matrix[0][0]);
        int endTime = matrix[0][2];

        // looping for the remaining activities
        for (int i = 1 ; i < end.length ; i++) {
            if (start[i] >= endTime) {
                ans.add(matrix[i][0]);
                endTime = matrix[i][2];
                count++;
            }
        }

        for (int i = 0 ; i < ans.size() ; i++) {
            System.out.println("A"+ans.get(i));
        }

    }

}