public class Solution {
    
    public static int maxArea(int[] height) {
        int maxWater = 0;
        int lp = 0, rp = height.length - 1;
        while (lp <= rp) {
            int curWater = Math.min(height[lp], height[rp]) * (rp - lp);
            maxWater = Math.max (maxWater, curWater);
            if (height[lp] <= height [rp]) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main (String args[])  {
    int arr[] = {2,3,4,5,18,17,6};
    System.out.println(maxArea(arr));
    }
}