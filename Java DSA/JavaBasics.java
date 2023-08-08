import java.util.*;

public class JavaBasics {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
       ArrayList<Integer> union = new ArrayList<>();
       int i = 0, j = 0;
       while (i < n && j < m) {
           if (arr1[i] < arr2[j]) {
               i++;
           } else if (arr1[i] > arr2[j]) {
               j++;
           } else {
               if (union.size()==0 || union.get(union.size()-1)!=arr1[i]) {
                   union.add(arr1[i]);
               }
               i++;
               j++;
           }
       }
       
    return union;
    }
    public static void main (String args[]) {
        int arr1[] = {1,2,2,4,5};
        int arr2[] = {2,3,4,5};
        int n = arr1.length;
        int m = arr2.length;
        System.out.println(findUnion(arr1, arr2, n, m));
    }
}
