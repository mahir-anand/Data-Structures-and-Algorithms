class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int key = 0;
        while (key < nums.length) {
            if (nums[key] == key + 1 || nums [nums[key] - 1] == nums[key]) {
                key ++;
            } else {
                int temp = nums[ nums[key] - 1];
                nums[ nums[key] -1 ] = nums [key];
                nums [key] = temp;
            }
        }
        
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] != i+1) {
                arr.add(i+1);
            }
        }
        
        return arr;
    }
}