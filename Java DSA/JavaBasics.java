public class JavaBasics {

    public static void subsets(String str, String ans, int i) {
        //base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("Null");
            }
            System.out.println(ans);
            return;
        }
        //recursion
        //Choice Yes
        subsets(str, ans+str.charAt(i), i+1);
        //Choice No
        subsets(str, ans, i+1);
    }

    public static void main (String args[]) {
        String str = "abc";
        subsets(str, "", 0);
    }

}