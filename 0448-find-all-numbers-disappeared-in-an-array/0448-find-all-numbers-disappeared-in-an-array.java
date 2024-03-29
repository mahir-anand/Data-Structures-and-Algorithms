class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0 ; i < nums.length ; i++) {
            nums [ Math.abs(nums[i]) - 1 ] = Math.abs ( nums [ Math.abs(nums[i]) - 1] ) * -1;
        }
        
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] > 0) {
                arr.add(i+1);
            }
        }
        
        return arr;
    }
}