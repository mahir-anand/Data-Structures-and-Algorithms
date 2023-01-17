public class JavaBasics {

    public static void changeArr (int arr[], int start, int num) {
        // base case
        if (start == arr.length) {
            printArr(arr);
            return;
        }
        //recursion
        arr[start] = num;
        changeArr (arr, start+1, num+1); //recursive call
        arr[start] -= 2; //backtracking step
    }

    public static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main (String args[]) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
    }

}