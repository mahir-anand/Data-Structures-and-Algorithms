class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0 ; i < image.length ; i++) {
            for (int j = 0 ; j < (image[i].length + 1) / 2 ; j ++) {
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][image[i].length - j -1] ^ 1;
                image[i][image[i].length - j - 1] = temp;
                
            }
        }
        
        return image;
    }
}