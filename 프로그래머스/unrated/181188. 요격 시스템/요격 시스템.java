import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        int len = targets.length;

        Arrays.sort(targets, (m1, m2) -> {
            return m1[1] - m2[1];
            });
        int nowEnd = 0;
        for(int i = 0; i < len; i++) {
            if(nowEnd <= targets[i][0]) {
                answer++;
                nowEnd = targets[i][1];
            }
        }
        return answer;
    }
}