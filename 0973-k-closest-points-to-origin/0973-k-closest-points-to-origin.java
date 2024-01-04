class Solution {
    
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        
        public Point (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
        
        @Override
        public int compareTo (Point p2) {
            return this.dist - p2.dist;
        }
        
        
    }
    
    public int[][] kClosest(int[][] points, int k) {
        
        //ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0 ; i < points.length ; i++) {
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            pq.add(new Point(points[i][0], points[i][1], dist));
        }
        
        ArrayList<Point> temp = new ArrayList<>();
        for (int i = 0 ; i < k ; i++) {
            temp.add(pq.remove());
        }
        
        int[][] ans = new int[temp.size()][2];
        for (int i = 0 ; i < temp.size() ; i++) {
            ans[i][0] = temp.get(i).x;
            ans[i][1] = temp.get(i).y;
        }
        
        return ans;
        
        
        
    }
}