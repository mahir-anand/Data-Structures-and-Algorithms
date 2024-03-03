class Solution {
    
    static class Row implements Comparable<Row> {
        int soldiers;
        int i;
        
        public Row (int soldiers, int i) {
            this.soldiers = soldiers;
            this.i = i;
        }
        
        @Override
        public int compareTo (Row r2) {
            if (this.soldiers == r2.soldiers) {
                return this.i - r2.i;
            } else {
                return this.soldiers - r2.soldiers;
            }
        }
        
    }
    
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        
        for (int i = 0 ; i < mat.length ; i++) {
            int count = 0;
            for (int j = 0 ; j < mat[0].length ; j++) {
                if (mat[i][j] == 1) {
                    count += 1;
                }
            }
            pq.add(new Row (count, i));
        }
        
        List<Integer> temp = new ArrayList<>();
        
        for (int i = 0 ; i < k ; i++) {
            temp.add(pq.remove().i);
        }
        
        int[] ans = new int[temp.size()];
        
        for (int i = 0 ; i < temp.size() ; i++) {
            ans[i] = temp.get(i);
        }
        
        return ans;
        
    }
}