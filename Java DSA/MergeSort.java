import java.util.Arrays;

public class MergeSort {

    public static void mergeSort (int[] arr, int start, int end) {
        
        if (start >= end) {
            return;
        }

        int mid = start + (end - start)/2;

        mergeSort (arr, start, mid);
        mergeSort (arr, mid+1, end);

        merge (arr, start, mid, end);

    }

    public static void merge (int[] arr, int start, int mid, int end) {
        
        int[] ans = new int [(end - start) + 1];
        // int mid = start + (end - start)/2;

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                ans[k] = arr[i];
                k++;
                i++;
            } else {
                ans[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            ans[k] = arr[i];
            i++; 
            k++;
        }

        while (j <= end) {
            ans[k] = arr[j];
            j++;
            k++;
        }

        i = start;
        for (int l = 0 ; l < ans.length ; l++) {
            arr[i] = ans[l];
            i++;
        }
    }

    public static void main (String args[]) {
        int[] arr = {5,4,1,3,2};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    
}
