class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length ; i++) {

            if (nums[i] > 0) {
                break;
            }
            
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int low = i + 1, high = nums.length - 1;

            while (low < high) {

                if (nums[i] + nums[low] + nums[high] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    ans.add(temp);
                    low += 1;
                    while (low < high && nums[low] == nums[low-1]) {
                        low += 1;
                    }
                    high -= 1;
                    while (low < high && nums[high] == nums[high+1]) {
                        high -= 1;
                    }
                } 
                
                else if (nums[i] + nums[low] + nums[high] < 0) {
                    low += 1;
                    while (low < high && nums[low] == nums[low-1]) {
                        low += 1;
                    }
                } 
                
                else if (nums[i] + nums[low] + nums[high] > 0) {
                    high -= 1;
                    while (low < high && nums[high] == nums[high+1]) {
                        high -= 1;
                    }
                }
            
            }

        }

        return ans;

    }
}