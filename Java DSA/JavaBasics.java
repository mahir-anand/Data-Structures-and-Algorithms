public class JavaBasics {

    public static void permutation (String str, String ans) { // "abc" , ""
        //base case

        //recursion
        newStr = str.substring(0,i) + str.substring(i+1);
        permutation(newStr, ans+str.charAt(i));
    }
    public static void main (String args[]) {

    }

}