class Solution {
    public int findDuplicate(int[] nums) {
        int key = 0;
        while (key < nums.length) {
            if (nums[key] == key + 1) {
                key ++;
            } else if (nums[nums[key]-1] == nums[key]) {
                return nums[key];
            } else {
                int temp = nums [nums[key] - 1];
                nums[nums[key] - 1] = nums[key];
                nums[key] = temp;
            }
        }
        
        return -1;
        
    }
}