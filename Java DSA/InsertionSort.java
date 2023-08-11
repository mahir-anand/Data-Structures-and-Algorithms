public class InsertionSort {
    
    public static void insertion (int arr[]) {
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            int j = i + 1;
            while (j > 0) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                } else {
                    break;
                }
            }
        }
    }
    public static void main (String args[]) {
        int arr[] = {0};
        insertion(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
