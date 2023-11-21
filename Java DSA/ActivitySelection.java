import java.util.ArrayList;

public class ActivitySelection {
    
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};
        
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        // adding the first activity
        count = 1;
        ans.add(0);
        int endTime = end[0];

        // looping for the remaining activities
        for (int i = 1 ; i < end.length ; i++) {
            if (start[i] >= endTime) {
                ans.add(i);
                endTime = end[i];
                count++;
            }
        }

        for (int i = 0 ; i < ans.size() ; i++) {
            System.out.println("A"+ans.get(i));
        }

    }

}