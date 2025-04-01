import java.util.*;

class Solution {
    int len, answer, n, m;
    Set<String> set;
    int[][] info;
    public int solution(int[][] info, int n, int m) {
        len = info.length;
        answer = Integer.MAX_VALUE;
        this.info = info;
        this.n = n;
        this.m = m;
        
        set = new HashSet<>();
        
        dfs(0, 0, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dfs(int idx, int a, int b) {
        if (idx == len) {
            answer = Math.min(answer, a);
            return;
        }
        
        String key = idx + "-" + a + "-" + b;
        if (set.contains(key)) {
            return;
        }
        set.add(key);
        
        int NA = a + info[idx][0];
        int NB = b + info[idx][1];
        
        if (NA < n && NA < answer) {
            dfs(idx + 1, NA, b);
        }
        
        if (NB < m) {
            dfs(idx + 1, a, NB);
        }
    }
}