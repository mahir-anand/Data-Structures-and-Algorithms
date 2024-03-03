class Solution {
    
    static class pair implements Comparable<pair> {
        int val;
        int idx;
        
        public pair (int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
        
        @Override
        public int compareTo (pair p2) {
            return p2.val - this.val;
        }
        
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] ans = new int[nums.length - k + 1];
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        
        for (int i = 0 ; i < k ; i++) {
            pq.add(new pair(nums[i], i));
        }
        
        ans[0] = pq.peek().val;
        
        int j = 1;
        for (int i = k ; i < nums.length ; i++) {
            
            while (pq.size() > 0 && pq.peek().idx <= i-k) {
                pq.remove();
            }
            
            pq.add(new pair(nums[i],i));
            
            ans[j] = pq.peek().val;
            j++;
        }
        
        
        
        return ans;
        
    }
}