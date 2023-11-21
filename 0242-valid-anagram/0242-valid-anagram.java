class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }
        
        for (int i = 0 ; i < s.length() ; i++) {
            int index = t.indexOf(s.charAt(i));
            if (index != -1) {
                t = t.substring(0,index) + t.substring(index+1,t.length());
            } else {
                return false;
            }
        }
        
        return t.isEmpty();
        
    }
}

