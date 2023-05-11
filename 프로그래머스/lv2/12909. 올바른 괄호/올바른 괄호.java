import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '('){
                stack.push(1);
            } else {
                if(stack.size() == 0) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if(stack.size() != 0)
            answer = false;
        return answer;
    }
}