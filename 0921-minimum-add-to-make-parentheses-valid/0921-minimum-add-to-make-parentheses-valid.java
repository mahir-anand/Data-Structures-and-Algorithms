class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for (int i = 0 ; i < s.length() ; i++) {
           
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        count++;
                    }
                }
            }

        }
        
        while (!stack.isEmpty()) {
            stack.pop();
            count++;
        }
        
        return count;    

    }
}