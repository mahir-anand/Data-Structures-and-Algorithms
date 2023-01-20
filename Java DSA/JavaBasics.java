public class JavaBasics {

    public static void permutation (String str, String ans) { // "abc" , ""
        //base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        //recursion
        for (int i = 0 ; i < str.length() ; i++) { 
            String newStr = str.substring(0,i) + str.substring(i+1);
            permutation(newStr, ans + str.charAt(i));
        }
    }
    public static void main (String args[]) {
        String str = "abc";
        permutation(str, "");
    }

}