public class JavaBasics {

    public static int maxSum (int arr[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length ; i++) {
            sum += arr [i];
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;
    }
    
    public static void main (String args[]) {
        int arr[] = {-2,-3,1,3,6,4,5,-3};
        System.out.println(maxSum(arr));
    }
}