public class SumOfDigits {
    
    public static int sum (int num) {

        if (num%10 == num) {
            return num;
        }
        
        int add = (num % 10) + sum(num/10);

        return add;
        
    }
    public static void main (String args[]) {
        int num = 1034;
        System.out.println(sum(num));

    }
}
