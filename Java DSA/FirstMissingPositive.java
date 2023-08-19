public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int key = 0;
        while (key < nums.length) {
            if (nums[key] > 0 && nums[key] <= nums.length) {
                if (nums[key] == key + 1 || nums[nums[key]-1] == nums[key])  {
                    key ++;
                } else {
                    int temp = nums[nums[key] - 1];
                    nums[nums[key] - 1] = nums[key];
                    nums[key] = temp;
                    }
            } else {
                key++;
            }

        }

        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        
        return nums.length + 1;
    }

    public static void main (String args[]) {
            int arr[] = {2,2};
            System.out.println(firstMissingPositive(arr));
    }

}
