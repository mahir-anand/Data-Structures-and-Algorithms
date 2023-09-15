import java.util.*;

public class Stacks {

    public static void printStack (Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void nextGreat (int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = nums.length - 1 ; i >= 0 ; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = nums [s.peek()];
            }
            s.push(i);
        }

        for (int i: result) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,-100,-2,-9,12,4};
        nextGreat(nums);
    }

}
