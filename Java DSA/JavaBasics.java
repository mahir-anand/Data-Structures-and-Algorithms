public class JavaBasics {

   
    public static void moveZeroes(int[] nums) {
        int i = -1 ;
        int j = 0 ;
        int n = nums.length;
        while (j < n) {
            if (nums[j] != 0) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            } else {
                j++;
            }
        }
    }

    public static void main (String args[]) {
        int num[] = {0,1,0,0,2,0,4};
        moveZeroes(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}