class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int negCount = 0;
        int negMax = Integer.MIN_VALUE;
        for (int i = 0 ; i < nums.length ; i ++) {
            if (nums[i] < 0) {
                negCount ++;
                negMax = Math.max(negMax, nums[i]);
            }
            curSum += nums[i];
            if (curSum < 0) {
                curSum = 0;
            }
            maxSum = Math.max(curSum,maxSum);
        }
        if (negCount == nums.length) {
            return negMax;
        }
        return maxSum;
    }
}