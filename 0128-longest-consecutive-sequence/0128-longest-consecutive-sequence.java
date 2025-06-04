class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int longest = 0;
        for (int num: set) {

            if (!set.contains(num-1)) {
                int count = 1;
                int j = num+1;
                while (set.contains(j)) {
                    count += 1;
                    j += 1;
                    }

                longest = Math.max(longest,count);
            }

        }

        return longest;

    }
}
