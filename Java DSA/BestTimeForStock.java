public class BestTimeForStock {
    
    public static int profit (int price[]) {
        int max = Integer.MIN_VALUE;
        int buy = Integer.MAX_VALUE;

        for (int i = 0 ; i < price.length ; i++) {
            if (price[i] < buy) {
                buy = price[i];
            }

            int profit = price[i] - buy;
            max = Math.max (max,profit);
        }

        return max;
    }
    public static void main (String args[]) {
        int price[] = {1,2,3,4,5};
        System.out.println(profit(price));
    }
}
