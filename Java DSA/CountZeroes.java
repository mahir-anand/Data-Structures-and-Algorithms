public class CountZeroes {

    public static int count (int num) {

        if (num % 10 == num) {
            return 0;
        }

        if (num % 10 == 0) {
            return 1 + count (num / 10);
        } else {
            return count (num / 10);
        }

    }
    public static void main (String args[]) {
        int num = 1;
        System.out.println(count(num));
    }
    
}
