class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        return letters(digits, 0, "", list);
    }
    
    public List<String> letters (String digits, int pos, String ans, List<String> list) {
        
        char[][] L = { {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'} };
        
        if (digits.length() == 0) {
            return list;
        } else if (pos == digits.length()) {
            list.add(ans);
            return list;
        }
        
        char currLetters[] = L [Character.getNumericValue(digits.charAt(pos)) - 2];
        for (int i = 0 ; i < currLetters.length ; i++) {
            letters(digits, pos + 1, ans + currLetters[i], list);
        }
        
        return list;
        
    }
    
}