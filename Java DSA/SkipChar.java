public class SkipChar {

    public static String skipChar (String str) {

        if (str.isEmpty()) {
            return "";
        }

        char ch = str.charAt(0);

        if (ch == 'a') {
            return skipChar(str.substring(1));
        } else {
            return ch + skipChar(str.substring(1));
        }

    }
    public static void main (String args[]) {
        String str = "baccad";
        System.out.println(skipChar(str));
    }
    
}
