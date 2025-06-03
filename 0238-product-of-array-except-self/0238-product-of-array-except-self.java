class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int pf = 1;
        for (int i = 1 ; i < ans.length ; i++) {
            ans[i] = pf * nums[i-1];
            pf *= nums[i-1];
        }

        int nf = nums[nums.length-1];
        for (int i = ans.length - 2 ; i >= 0 ; i--) {
            ans[i] = ans[i] * nf;
            nf = nf * nums[i];
        }
        
        return ans;

    }
}