class Solution {
    public int maxArea(int[] height) {
        
        int water = 0;
        int start = 0, end = height.length - 1;

        while (start < end) {
            int temp = Math.min(height[start], height[end]) * (end-start);
            water = Math.max(water, temp);
            if (height[start] < height[end]) {
                start += 1;
            } else {
                end -= 1;
            }
        }

        return water;

    }
}