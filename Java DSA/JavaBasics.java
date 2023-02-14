public class JavaBasics {

   
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        //one part
        reverse(nums,0,n-k-1);
        //second part
        reverse(nums,n-k,n-1);
        //whole
        reverse(nums,0,n-1);
    }
    public static void reverse (int nums[], int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main (String args[]) {
        int num[] = {1,2,4,4};
        rotate(num,1);
        for (int i = 0 ; i < num.length ; i++) {
            System.out.print(num[i] + " ");
        }
    }
}