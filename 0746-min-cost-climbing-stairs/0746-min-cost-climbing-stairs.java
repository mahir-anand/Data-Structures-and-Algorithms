class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        if (cost.length == 3) {
            return Math.min(cost[0] + cost[2], cost[1]);
        }

        int[] one = new int[cost.length]; 
        int[] second = new int[cost.length];
        one[0] = cost[0];
        one[1] = 10000;
        second[0] = 10000;
        second[1] = cost[1];
        
        for (int i = 2 ; i < cost.length ; i++) {
            one[i] = Math.min(cost[i]+one[i-1], cost[i]+one[i-2]);
            second[i] = Math.min(cost[i] + second[i-1], cost[i] + second[i-2]);
        }

        int min1 = Math.min(one[cost.length-1], second[cost.length-1]);
        int min2 = Math.min(one[cost.length-2], second[cost.length-2]);
        return Math.min(min1, min2);

    }
}