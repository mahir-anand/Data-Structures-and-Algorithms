public class JavaBasics {

    public static int trappedWater (int height[]) {
        int leftMax[] = new int [height.length];
        int rightMax[] = new int [height.length];
        int water = 0;

        leftMax[0] = height[0];
        for (int i = 1 ; i < height.length ; i ++) {
            leftMax [i] = Math.max(height[i],leftMax[i-1]);
        }

        rightMax[height.length-1] = height[height.length-1];
        for (int i = height.length - 2 ; i >=0 ; i--) {
            rightMax [i] = Math.max(height[i],rightMax[i+1]);
        }

        for (int i = 0 ; i < height.length ; i++) {
            water += Math.min(rightMax[i],leftMax[i]) - height[i];
        }

        return water;
    }
    public static void main (String args[]) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(trappedWater(height));
    }
}