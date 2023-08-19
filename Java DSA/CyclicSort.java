public class CyclicSort {

    public static void cyclicSort (int arr[]) {
        int key = 0;
        while (key < arr.length) {
            if (key == arr[key] - 1) {
                key ++;
            } else {
                int temp = arr[ arr[key] - 1];
                arr[ arr[key] - 1] = arr[key];
                arr [key] = temp;
            }
        }
    }
    public static void main (String args[]) {
        int arr[] = {5,4,3,2,1};
        cyclicSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}



