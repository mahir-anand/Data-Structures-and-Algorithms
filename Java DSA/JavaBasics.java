public class JavaBasics {

    public static String[] mergeSort (String[] arr, int start, int end) {
        //base case
        if (start == end) {
            String[] a = { arr[start] };
            return a;
        }
        //recursive calls
        int mid = start + (end - start)/2;
        String[] arr1 = mergeSort(arr, start, mid);
        String[] arr2 = mergeSort(arr, mid + 1, end);
        return merge(arr1, arr2);
        
    }

    public static String[] merge (String[] arr1, String[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        String[] arr3 = new String[m+n];

        int idx = 0, i = 0, j = 0;

        while (i<m && j<n) {
            if (findSmaller(arr1[i],arr2[j])) {
                arr3[idx] = arr1[i];
                i++;
            } else {
                arr3[idx] = arr2[j];
                j++;
            }
            idx++;
        }

        while (i<m) {
            arr3[idx++] = arr1[i++];
        }

        while (j<n) {
            arr3[idx++] = arr2[j++];
        }

        return arr3;

    }

    public static boolean findSmaller (String a, String b) {
        if (a.compareTo(b) < 0 ) {
            return true;
        }
        return false;
    }

    public static void main (String args[]) {
        String[] arr = {"sun","earth","mars","mercury"};
        String[] ans = mergeSort(arr, 0, arr.length-1);
        for (String i : ans) {
            System.err.print(i + " ");
        }
    }

}