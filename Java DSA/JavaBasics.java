public class JavaBasics {

    public static int print2largest(int arr[], int n) {
        
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0 ; i < n ; i ++) {
            if (arr[i] < min) {
                secMin = min;
                min = arr[i];
                count++;
            } else if (arr[i] < secMin && arr[i] != min) {
                secMin = arr[i];
                count++;
            }
        }
        if (count < 2) {
            return -1;
        } else {
            return secMin; 
        }
        
       }
        

    public static void main (String args[]) {
        int num[] = {2,2,2,2,2,2,2};
        System.out.println(print2largest(num, 7));
    }
}