class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }

        int[] skip_first = new int[nums.length];
        int[] skip_last = new int[nums.length];

        skip_first[0] = 0;
        skip_first[1] = Math.max(nums[1], skip_first[0]);
        for (int i = 2 ; i < nums.length ; i++) {
            skip_first[i] = Math.max(skip_first[i-1], skip_first[i-2] + nums[i]);
        }

        skip_last[0] = nums[0];
        skip_last[1] = Math.max(skip_last[0],nums[1]);
        for (int i = 2 ; i < nums.length - 1; i++) {
            skip_last[i] = Math.max(skip_last[i-1], skip_last[i-2] + nums[i]);
        }
        skip_last[nums.length - 1] = skip_last[nums.length - 2];

        return Math.max(skip_first[nums.length - 1], skip_last[nums.length - 2]);


    }
}