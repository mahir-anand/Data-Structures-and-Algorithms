import java.util.Arrays;

public class QuickSort {

    public static void quick (int[] arr, int low, int end) {

        if (low >= end) {
            return;
        }
        
        int i = low, j = end;
        int mid = low + (end - low)/2;
        int pivot = arr[mid];

        while (j >= i) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (j >= i) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            
        }

        quick (arr, low, j);
        quick (arr, i, end);

    }
    public static void main (String args[]) {
        int[] arr = {-1,0,100,1,5,2,4,9,3,6};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    
}
