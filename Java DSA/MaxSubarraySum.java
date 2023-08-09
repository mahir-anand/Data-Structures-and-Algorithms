public class MaxSubarraySum {
    
    public static int maxSubarraySum(int arr[]) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int maxNeg = Integer.MIN_VALUE;
        int negCount = 0;

        for (int i = 0 ; i < arr.length ; i++) {

            if (arr[i] < 0) {
                negCount++;
                maxNeg = Math.max(arr[i],maxNeg);
            }

            curSum += arr[i];

            if (curSum < 0) {
                curSum = 0;
            }
            maxSum = Math.max (curSum,maxSum);
        }

        if (negCount == arr.length) {
            return maxNeg;
        }
        return maxSum;
    }
    public static void main (String args[]) {
        int arr[] = {-1,-2};
        System.out.println(maxSubarraySum(arr));
    }
}
