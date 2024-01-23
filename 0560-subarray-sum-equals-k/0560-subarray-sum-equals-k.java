class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0, count = 0;
        map.put(0,1);
        
        for (int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            int check = sum - k;
            if (map.containsKey(check)) {
                count += map.get(check);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        
        return count;
        
    }
}