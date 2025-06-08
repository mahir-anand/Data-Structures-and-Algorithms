class Solution {
    public int maxArea(int[] height) {
        
        int water = 0;
        int low = 0, high = height.length - 1;

        while (low < high) {
            int temp = Math.min(height[low], height[high]) * (high-low);
            water = Math.max(water, temp);
            if (height[low] < height[high]) {
                low += 1;
            } else {
                high -= 1;
            }
        }

        return water;

    }
}