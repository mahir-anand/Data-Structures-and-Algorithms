class Solution {
    public int splitArray(int[] nums, int k) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        
        for (int i = 0 ; i < nums.length ; i++) {
            end += nums[i];
            start = Math.max(start, nums[i]);
        }
        
        while (start < end) {
            int mid = start + (end - start)/2;
            
            int part = 1;
            int sum = 0;
            for (int i = 0 ; i < nums.length ; i++) {
                if (sum + nums[i] > mid) {
                    sum = nums[i];
                    part++;
                } else {
                    sum += nums[i];
                }
            }
            
            if (part > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
            
        }
        
        return start;
        
    }
}