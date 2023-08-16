public class RecursiveSelectionSort {
    
    static int key = 0;
    static int min = Integer.MAX_VALUE;

    public static void selection (int[] arr, int start, int index, int min) {

        if (start >= arr.length) {
            return;
        }

        if (index >= arr.length - 1) {
            int temp = arr[start];
            arr[start] = arr[min];
            arr[min] = temp;
            selection(arr, start+1, start+1,start+1);
            return;
        }
        
        if (arr[index+1] < arr[min]) {
            selection(arr, start, index+1,index+1);
        } else {
            selection(arr, start, index+1,min);
        }
        
    }
    public static void main (String args[]) {
        int[] arr = {-1,-100,0,100,5,4,3,2,1};
        selection(arr, 0, 0,0);
        for (int i : arr) {
            System.out.print( i + " ");
        }
    }
}
