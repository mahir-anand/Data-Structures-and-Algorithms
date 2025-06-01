class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        
        map.forEach((num, freq) -> {
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            } 
            bucket[freq].add(num);
        });

        List<Integer> ans = new ArrayList<>();

        for (int i = bucket.length - 1 ; i >=0 && ans.size() < k ; i--) {
            if(bucket[i] != null) {
                ans.addAll(bucket[i]);
            }
        }

        
        int[] arr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            arr[i] = ans.get(i);
        }
        
        return arr;



    }
}