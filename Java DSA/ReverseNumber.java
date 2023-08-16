public class ReverseNumber {

    public static int reversal (int num) {

        if (num % 10 == num) {
            return num;
        }

        int rem = num % 10;
        int digits = (int)(Math.log10(num)) + 1;
        return rem * ((int)Math.pow(10,digits-1)) + reversal (num / 10);
        
    }
    public static void main (String args[]) {
        int num = 1001;
        System.out.println(reversal(num));
    }
    
}
