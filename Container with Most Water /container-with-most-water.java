public class Solution {
    
    public static boolean pairSum(int[] arr, int target) {
        int lp = 0, rp = arr.length - 1;
        while (lp < rp) {
            if (arr[lp] + arr[rp] == target) {
                return true;
            } else if (arr[lp] + arr[rp] < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static void main (String args[])  {
    int arr[] = {2,3,4,5,18,17,6};
    System.out.println(pairSum(arr,9));
    }
}