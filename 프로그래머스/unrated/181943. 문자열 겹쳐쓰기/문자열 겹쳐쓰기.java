class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        int overLen = overwrite_string.length();
        StringBuilder sb = new StringBuilder(my_string);
        
        for(int i = s; i < s + overLen; i++){
            sb.setCharAt(i, overwrite_string.charAt(i - s));
        }
        
        String answer = sb.toString();
        return answer;
    }
}