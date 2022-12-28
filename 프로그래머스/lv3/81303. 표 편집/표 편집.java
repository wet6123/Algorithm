import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int len = cmd.length;
        Stack<Integer> history = new Stack<Integer>();
        
        for(int i = 0; i < len; i++){
            char order = cmd[i].charAt(0);
            
            if(order == 'U'){
                k -= Integer.parseInt(cmd[i].substring(2));
            }else if(order == 'D'){
                k += Integer.parseInt(cmd[i].substring(2));
            }else if(order == 'C'){
                history.push(k);
                if(k == n - history.size()){
                    k--;
                }
            }else if(order == 'Z'){
                int idx = history.pop();
                if(idx <= k){
                    k++;
                }
            }
        }
        StringBuffer buf = new StringBuffer("");
        for(int i = 0; i < n - history.size(); i++){
            buf.append("O");
        }
        
        while(!history.isEmpty()){
            buf.insert(history.pop(), "X");
        }
        String answer = buf.toString();
        return answer;
    }
}