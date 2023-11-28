class Solution {
    public int maximum69Number (int num) {
        String str = Integer.toString(num);
        int idx = -1;
        for (int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == '6') {
                idx = i;
                break;
            }
        }
        
        if (idx == -1) {
            return num;
        }
        
        int i = 0;
        int ans = 0;
        while (i < idx) {
            ans = (ans * 10) + Character.getNumericValue(str.charAt(i));
            i++;
        }
        
        ans = (ans * 10) + 9;
        idx++;
        
        while (idx < str.length()) {
            ans = (ans * 10) + Character.getNumericValue(str.charAt(idx));
            idx++;
        }
        
        return ans;
    }
}