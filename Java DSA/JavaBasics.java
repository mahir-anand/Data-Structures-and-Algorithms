public class JavaBasics {

    public static int print2largest(int arr[], int n) {
        
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0 ; i < n ; i ++) {
            if (arr[i] > max) {
                secMax = max;
                max = arr[i];
                count++;
            } else if (arr[i] > secMax && arr[i] != max) {
                secMax = arr[i];
                count++;
            }
        }
       
       if (count < 2) {
           return -1;
       } else {
        return secMax;   
       }
        
    }
    public static void main (String args[]) {
        int num[] = {2,1,4,5,6,4,3};
        System.out.println(print2largest(num, 7));
    }
}