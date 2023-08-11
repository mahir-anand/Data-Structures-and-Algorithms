public class CountingSort {

    public static void counting(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < arr.length ; i++) {
            max = Math.max(max,arr[i]);
        }

        int counts[] = new int [max + 1];

        for (int i = 0 ; i < arr.length ; i++) {
            counts[arr[i]]++;
        }

        int j = 0;
        for (int i = 0 ; i < counts.length ; i++) {
            while (counts[i] > 0) {
                arr[j] = i;
                counts[i]--;
                j++;
            }
        }

    }
    public static void main (String args[]) {
        int arr[] = {5,4,1,3,2,1};
        counting(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
    
}
