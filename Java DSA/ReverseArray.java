public class ReverseArray {

    public static void reverse(int arr[]) {
        for (int i = 0; i < arr.length/2 ; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
    public static void main (String args[]) {
        int arr[] = {2,4,6,8,10};
        reverse(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
}
