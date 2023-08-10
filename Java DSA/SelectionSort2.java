public class SelectionSort2 {

    public static void selection (int arr[]) {

        int key = arr.length - 1;

        while (key >= 0) {

            int max = key;

            for (int i = key ; i >= 0 ; i--) {
                if (arr[i] > arr[max]) {
                    max = i;
                }
            }

            int temp = arr[key];
            arr[key] = arr[max];
            arr[max] = temp;

            key--;

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
