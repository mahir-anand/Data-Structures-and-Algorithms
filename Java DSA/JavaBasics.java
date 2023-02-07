public class JavaBasics {

    public static int maxSum (int arr[]) {
        int sum = 0;
        int negCount = 0;
        int maxNeg = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg,arr[i]);
            }
            sum += arr [i];
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(sum,maxSum);

        }

        if (negCount == arr.length) {
            return maxNeg;
        }
        return maxSum;
    }
    
    public static void main (String args[]) {
        int arr[] = {-2,-3,1,3,6,4,5,-3};
        System.out.println(maxSum(arr));
    }
}