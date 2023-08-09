class Solution {
    public int maxArea(int[] height) {
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
}