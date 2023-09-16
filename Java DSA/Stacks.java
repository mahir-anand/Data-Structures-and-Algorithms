import java.util.*;

public class Stacks {

    public static void printStack (Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static int maxRect (int[] height) {
        Stack<Integer> s = new Stack<>();

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0 ; i < height.length ; i++) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = s.peek();
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            s.pop();
        }

        for (int i = height.length - 1 ; i >= 0 ; i--) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                right[i] = height.length;
            } else {
                right[i] = s.peek();
            }
            s.push(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < height.length ; i++) {
            int area = height[i] * (right[i] - left[i] - 1);
            max = Math.max(max, area);
        }

        return max;

    }
    

    public static void main(String[] args) {
        int[] height = {0,0,0,0,0};
        System.out.println(maxRect(height));
    }

}
