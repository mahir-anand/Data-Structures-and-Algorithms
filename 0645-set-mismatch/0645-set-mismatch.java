class Solution {
    public int[] findErrorNums(int[] nums) {
        int arr[] = new int[2];
        int key = 0;
        while (key < nums.length) {
            if (nums[key] == key + 1 || nums[nums[key]-1] == nums[key]) {
                key++;
            } else {
                int temp = nums [nums[key]-1];
                nums [nums[key]-1] = nums[key];
                nums[key] = temp;
            }
        }
        
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] != i + 1) {
                arr[0] = nums[i];
                arr[1] = i+1;
            }
        }
        
        return arr;
    }
}