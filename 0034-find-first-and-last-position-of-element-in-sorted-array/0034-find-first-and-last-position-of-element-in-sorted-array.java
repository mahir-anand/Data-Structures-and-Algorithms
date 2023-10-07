class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans1 = -1, ans2 = -1;
        int[] result = new int[2];
        
        while (start <= end) {
            int mid = (end + start)/2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans1 = mid;
                end = mid - 1;
            }
        }
        
        start = 0;
        end = nums.length - 1;
        
        while (start <= end) {
            int mid = (end + start)/2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans2 = mid;
                start = mid + 1;
            }
        }
        
        result[0] = ans1;
        result[1] = ans2;
        
        return result;
        
    }
}