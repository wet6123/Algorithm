import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int n, int k, int[] enemy) {
//         병사 n
//         무적권 k
//         몇 라운드까지 막을 수 있는지 출력
        int answer = 0;
        int len = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < len; i++) {
            pq.add(enemy[i]);
            while (n < enemy[i]) {
                if (k > 0) {
                    n += pq.poll();
                    k--;
                } else {
                    return answer;
                }
            }
            if (n >= enemy[i]) {
                n -= enemy[i];
            }
            answer++;
        }
        
        return answer;
    }
}