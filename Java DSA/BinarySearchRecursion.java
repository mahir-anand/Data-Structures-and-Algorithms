public class BinarySearchRecursion{

    public static int binarySearch (int arr[], int target, int start, int end) {
        int mid = start + (end - start)/2;
        if (start > end) {
            return -1;
        }
        if (arr[mid] ==  target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, end);
        }

    }
    public static void main (String args[]) {
        int arr[] = {2,4,6,8,10};
        System.out.println(binarySearch(arr, 10, 0, 4));
    }
    
}