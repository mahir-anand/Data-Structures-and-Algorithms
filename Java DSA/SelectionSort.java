public class SelectionSort {

    public static void selection (int arr[]) {

        int key = 0;

        while (key < arr.length - 1) {

            int min = key;

            for (int i = key + 1 ; i < arr.length ; i++) {
                if (arr[i] < arr[min]) {
                    min = i;
                }
            }

            int temp = arr[key];
            arr[key] = arr[min];
            arr[min] = temp;

            key++;

        }
       
    }
    public static void main (String args[]) {
        int arr[] = {56,4,-1,4,0,5};
        selection(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    
}
