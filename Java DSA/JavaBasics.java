public class JavaBasics {

    public static int count (int arr[], int num, int low, int high) {
        int count = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == num){
                count++;
            }
        }
        return count;
    }

    public static int majorityElement (int arr[], int low, int high) {
        //base case
        if (low == high) {
            return arr[low];
        }
        //recursive case
        int mid = low + (high - low)/2;
        int left = majorityElement(arr, low, mid);
        int right = majorityElement(arr, mid+1, high);

        //if the majority element is the same
        if (left == right) {
            return left;
        }

        //if the majority elements are different
        int countLeft = count(arr,left,low,high);
        int countRight = count(arr,right,low,high);

        if (countLeft > countRight) {
            return left;
        } else {
            return right;
        }

    }
    public static void main (String args[]) {
        int arr[] = {1,3,1,4,5,1,1,6,1,7};
        System.out.println(majorityElement(arr, 0, arr.length - 1));
    }

}