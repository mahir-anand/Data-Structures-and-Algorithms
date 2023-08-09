class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        int givenSum = 0;
        int expectedSum = (N * (N+1)) / 2;
        for (int i = 0 ; i < N ; i++) {
            givenSum += nums[i];
        }
        return expectedSum - givenSum;
        }
}