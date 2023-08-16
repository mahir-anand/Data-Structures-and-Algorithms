public class RecursiveBubbleSort {

    public static void bubble (int[] arr, int start, int index) {
        if (start >= arr.length) {
            return;
        }

        if (index == arr.length - 1) {
            bubble(arr,start+1,0);
            return;
        }

        if (arr[index] > arr[index+1]) {
            int temp = arr[index+1];
            arr[index+1] = arr[index];
            arr[index] = temp;
            bubble(arr,start,index+1);
        } else {
            bubble(arr,start,index+1);
        }

    }
    public static void main (String args[]) {
        int[] arr = {5,4,3,2,1};
        bubble(arr, 0, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
}
