class Solution {
    public int[] sortArray(int[] nums) {
        
        //build max heap
        int n = nums.length;
        for (int i = n/2 ; i >= 0 ; i--) {
            heapify(nums,i,n);
        }
        
        //swap first and last
        for (int i = n-1 ; i >= 0 ; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            
            heapify(nums,0,i);
        }
        
        return nums;
        
    }
    
    public static void heapify (int[] nums, int i, int n) {
        
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        
        if (left < n && nums[left] > nums[max]) {
            max = left;
        }

        if (right < n && nums[right] > nums[max]) {
            max = right;
        }
        
        if (max != i) {
            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
            
            heapify(nums,max,n);
        }
        
    }
    
}