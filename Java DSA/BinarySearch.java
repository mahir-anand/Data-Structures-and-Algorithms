public class BinarySearch {

    public static int binarySearch(int arr[], int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }

        return -1;

    }
    public static void main (String args[]) {
        int arr[] = {2,4,6,8,10};
        System.out.println(binarySearch(arr, 8));
    }
}