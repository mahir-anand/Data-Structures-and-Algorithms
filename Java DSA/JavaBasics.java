public class JavaBasics {

    public static StringBuilder compress (String s) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0 ; i < s.length(); i++) {
            Integer count = 0;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                i++;
                count++;
            }
            temp.append(s.charAt(i));
            if (count > 0) {
                temp.append(count);
            }
        }

        return temp;
    }
    public static void main (String args[]) {
        String s = "aabbbczzzzzż";
        System.out.println(compress(s));
    }
}