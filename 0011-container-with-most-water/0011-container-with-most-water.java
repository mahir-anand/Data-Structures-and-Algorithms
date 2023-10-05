class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int curWater = 0;
        int maxWater = Integer.MIN_VALUE;
        
        while (left < height.length && right >= 0 && left < right ) {
            curWater = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, curWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
        
    }
}

