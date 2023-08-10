public class TrappedRainWater {

    public static int rainwater (int height[]) {

        //water = min (rmax, lmax) - height[i]
        int water = 0;
        int lmax[] = new int [height.length];
        int rmax[] = new int [height.length];

        lmax[0] = height[0];
        rmax[height.length-1] = height[height.length-1];

        for (int i = 1 ; i < height.length ; i++) {
            if (height[i] > lmax[i-1]) {
                lmax[i] = height[i];
            } else {
                lmax[i] = lmax[i-1];
            }
        }

        for (int i = height.length - 2 ; i >= 0 ; i--) {
            if (height[i] > rmax[i+1]) {
                rmax[i] = height[i];
            } else {
                rmax[i] = rmax[i+1];
            }
        }

        for (int i = 0 ; i < height.length ; i++) {
            water += Math.min(rmax[i],lmax[i]) - height[i];
        }

        return water;

    }
    public static void main (String args[]) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(rainwater(height));
    }
    
}
