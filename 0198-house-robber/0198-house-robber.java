class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }

        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[1], max[0]);

        for (int i = 2 ; i < nums.length ; i++) {
            max[i] = Math.max(max[i-1],nums[i]+max[i-2]);
        }

        return max[max.length-1];

    }
}