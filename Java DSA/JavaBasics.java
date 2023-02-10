public class JavaBasics {

    public static boolean isPalindrome(String s) {
        String temp = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                temp += c;
            }
        }

        for (int i = 0 ; i < temp.length()/2 ; i++) {
            if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
    public static void main (String args[]) {
        String s = " ";
        System.out.println(isPalindrome(s));
    }
}