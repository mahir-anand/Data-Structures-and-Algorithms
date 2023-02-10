public class JavaBasics {

    public static float shortestPath(String s) {
        int x = 0;
        int y = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
        }

        x = x*x;
        y = y*y;

        return (float)Math.sqrt(x+y);
    }
    public static void main (String args[]) {
        String s = "NWSE";
        System.out.println(shortestPath(s));
    }
}