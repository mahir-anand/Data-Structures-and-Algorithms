class Solution {
    public boolean isPalindrome(String s) {
        
        int l = 0, r = s.length() - 1;
        while (l < r) {

            while (l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l += 1;
            }

            while (r > l && !Character.isLetterOrDigit(s.charAt(r))){
                r -= 1;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l += 1;
            r -= 1;

        }

        return true;

    }
}