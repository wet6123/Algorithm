class Solution {
    public String solution(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환
        if (p.isEmpty()) {
            return "";
        }
        
        // 2. 문자열을 u, v로 분리
        int splitIndex = getSplitIndex(p);
        String u = p.substring(0, splitIndex);
        String v = p.substring(splitIndex);
        
        // 3. u가 올바른 괄호 문자열이면
        if (isCorrect(u)) {
            // 3-1. v에 대해 재귀적으로 수행한 결과를 붙여 반환
            return u + solution(v);
        }
        
        // 4. u가 올바른 괄호 문자열이 아니면
        StringBuilder answer = new StringBuilder();
        // 4-1, 4-2, 4-3. '(' + v에 대한 재귀 수행 결과 + ')'
        answer.append("(")
              .append(solution(v))
              .append(")");
        
        // 4-4. u의 첫번째와 마지막 문자를 제거하고 나머지 문자의 괄호 방향을 뒤집음
        if (u.length() > 2) {
            String reversed = reverseParentheses(u.substring(1, u.length() - 1));
            answer.append(reversed);
        }
        
        // 4-5. 생성된 문자열 반환
        return answer.toString();
    }
    
    // 균형잡힌 괄호 문자열의 분리 위치를 찾는 함수
    private int getSplitIndex(String w) {
        int count = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                return i + 1;
            }
        }
        return w.length();
    }
    
    // 올바른 괄호 문자열인지 검사하는 함수
    private boolean isCorrect(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }
    
    // 괄호 방향을 뒤집는 함수
    private String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}