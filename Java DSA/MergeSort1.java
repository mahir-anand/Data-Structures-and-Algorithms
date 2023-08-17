import java.util.Arrays;

public class MergeSort1 {

    public static int[] mergeSort (int[] arr) {
        
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] p1 = mergeSort (Arrays.copyOfRange(arr, 0, mid));
        int[] p2 = mergeSort (Arrays.copyOfRange(arr, mid, arr.length));

        return merge(p1,p2);

    }

    public static int[] merge (int[] arr1, int[] arr2) {
        
        int[] ans = new int [arr1.length + arr2.length];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i];
                k++;
                i++;
            } else {
                ans[k] = arr2[j];
                k++;
                j++;
            }
        }

        while (i < arr1.length) {
            ans[k] = arr1[i];
            i++; 
            k++;
        }

        while (j < arr2.length) {
            ans[k] = arr2[j];
            j++;
            k++;
        }

        return ans;
    }

    public static void main (String args[]) {
        int[] arr = {-1,100,0,5,4,3,2,1};
        arr = mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    
}
