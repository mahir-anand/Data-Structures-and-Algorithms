public class JavaBasics {

   
    public static int removeDuplicates(int arr[]) {
        int i = 0;
        for (int j = 1 ; j < arr.length ; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i+1;
    }

    public static void main (String args[]) {
        int num[] = {1,2,4,4};
        System.out.println(removeDuplicates(num));
    }
}