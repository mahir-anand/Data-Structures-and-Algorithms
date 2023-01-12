public class JavaBasics {

    public static int swapCount (int arr[], int start, int end)  {
        int count = 0;
        if ( end > start) {
            int mid = start + (end - start)/2;
            count = swapCount(arr, start, mid);
            count += swapCount(arr, mid+1, end);
            count += merge(arr,start,mid+1,end);
        }
        return count;
    }

    public static int merge (int arr[], int start, int mid, int end) {
        int count = 0;
        int k = 0, i = start, j = mid;
        int temp[] = new int[end-start+1];
        while (i < mid && j <=end) {
            if (arr[i]>arr[j]) {
                temp [k] = arr[j];
                j++;
                count += mid - i;
            } else {
                temp [k] = arr[i];
                i++;
            }
            k++;
        }

        while (i<mid) {
            temp[k++] = arr[i++];
        }

        while (j<=end) {
            temp[k++] = arr[j++];
        }

        k = 0;
        for (i = start; i < end; i++) {
            arr[i] = temp[k];
            k++;
        }

        return count;
    }

    public static void main (String args[]) {
        int arr[] = {5,5,5};
        System.out.println(swapCount(arr, 0, arr.length-1));
    }

}