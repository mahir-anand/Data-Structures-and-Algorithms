public class JavaBasics {

    public static void printArr(int arr[]) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort (int arr[], int start, int end) {
        //base case
        if (start >= end) {
            return;
        }
        //recursive calls
        int p = partition(arr, start, end);
        quickSort(arr,start,p -1);
        quickSort(arr,p+1,end);    
    }

    public static int partition (int arr[], int start, int end) {
        int pivot = arr[end];
        int i = start - 1 ;

        for (int j = start ; j < end ; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[j];
                i++;
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[end] = temp;

        return i;
    }

    public static void main (String args[]) {
        int arr[] = {4,5,3,2,6,7,5};
        quickSort(arr, 0 , arr.length-1);
        printArr(arr);
    }
}