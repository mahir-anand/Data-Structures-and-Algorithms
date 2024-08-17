class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        boolean[][] vis = new boolean[image.length][image[0].length];
        floodFillUtil (image, sr, sc, color, vis, image[sr][sc]);
        return image;
        
    }
    
    public void floodFillUtil (int[][] image, int sr, int sc, int color, boolean[][] vis, int orgClr) {
      
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgClr) {
            return;
        }
        
        image[sr][sc] = color;
        vis[sr][sc] = true;
        
        floodFillUtil (image, sr, sc-1, color, vis, orgClr);
        floodFillUtil (image, sr, sc+1, color, vis, orgClr);
        floodFillUtil (image, sr-1, sc, color, vis, orgClr);
        floodFillUtil (image, sr+1, sc, color, vis, orgClr);
        
    }
    
    
}