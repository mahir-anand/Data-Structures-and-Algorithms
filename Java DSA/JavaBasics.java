public class JavaBasics {

   public static void permutation (String str, String perString) { 
        //base case
        if (str.length() == 0) {
            System.out.println(perString);
            return;
        }
        //recursion
        for (int i = 0 ; i < str.length() ; i++) {
            // permutation(str.substring(0, i) + str.substring(i + 1), perString + str.charAt(i));
            // permutation(str.substring(0, i) + str.substring(i + 1),perString);
            String newStr = str.substring(0,i) + str.substring(i+1);
            permutation(newStr, perString + str.charAt(i));
        }
   }
    public static void main (String args[]) {
        String str = "abc";
        permutation(str, "");
    }
}