public class JavaBasics {
    
    public static void missing (int arr[]) {
        int xor = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            xor ^= arr[i];
        }

        for (int i = 1 ; i <= arr.length ; i++) {
            xor ^= i;
        }

        int rightSetBit = xor & -xor;

        int x = 0 , y = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if ((arr[i] & rightSetBit) == 1) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }

        for (int i = 1 ; i <= arr.length ; i++) {
            if ((i & rightSetBit) == 1) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == x) {
                System.out.println("Repeating : " + x);
                System.out.println("Missing : " + y);
                break;
            } else if (arr[i] == y) {
                System.out.println("Repeating : " + y);
                System.out.println("Missing : " + x);
                break;
            }
        }
    }

    public static void main (String args[]) {
        int arr [] = {1,2,1,4,5,6};
        missing(arr);
    }
}