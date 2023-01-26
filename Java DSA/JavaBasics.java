public class JavaBasics {

    public static void subString (String str, String sub, int i) {
        //base case
        if (i == str.length()) {
            if (sub == "") {
                System.out.println("Null");
            } else {
                System.out.println(sub);
            }
            return;
        }
        //recursion
        subString(str, sub + str.charAt(i), i+1); //yes choice
        subString(str, sub, i+1); //no choice
    }
    public static void main (String args[]) {
        String str = "abc";
        subString("abc","",0);
    }
}