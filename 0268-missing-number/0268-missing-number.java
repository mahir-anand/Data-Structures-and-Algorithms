class Solution {
    public int missingNumber(int[] nums) {
        int key = 0;
        while (key < nums.length) {
            if (key == nums[key]) {
                key ++;
            } else {
                if (nums [key] == nums.length) {
                    key ++;
                } else {
                    int temp = nums[ nums[key] ];
                    nums [ nums[key] ] = nums[key];
                    nums [key] = temp;
                }
            }
        }
        
        
        for (int i = 0 ; i < nums.length ; i++) {
            if (i != nums[i]) {
                return i;
            } 
        }
        
        return nums.length;
    }
}