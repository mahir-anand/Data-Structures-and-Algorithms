public class JavaBasics {

    static char[][] L = { {}, {} , {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, 
    {'t','u','v'}, {'w','x','y','z'}};

    public static void combFinder (String str, int pos, String comb) {
        if (str.length() == 0) {
            System.out.println("");
            return;
        } else if (pos == str.length()) {
            System.out.println(comb);
            return;
        }

        //recursion
        char curLetters [] = L[Character.getNumericValue (str.charAt(pos))];
        for (int i = 0 ; i < curLetters.length ; i++) {
            combFinder(str, pos+1, comb + curLetters[i]);
        }

    }

    public static void main (String args[]) {
        combFinder("2",0,"");
    }

}
