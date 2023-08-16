import java.util.ArrayList;

public class LinearRecursion {

    public static int linear (int[] arr, int target, int index) {
        if (index >= arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        } else {
            return linear(arr, target, index + 1);
        }
    }

    // static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList<Integer> linearAll (int[] arr, int target, int index, ArrayList<Integer> list) {

        if (index == arr.length) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
            linearAll(arr, target, index+1, list);
        } else {
            linearAll(arr, target, index + 1, list);
        }

        return list;
    }

    public static void main (String args[]) {
        int[] arr = {1,2,3,2,1};
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(linearAll(arr, 1, 0, list));
    }
    
}
