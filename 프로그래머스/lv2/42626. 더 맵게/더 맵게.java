import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        int len = scoville.length;
        for(int i = 0; i < len; i++) {
            pq.add(scoville[i]);
        }
        while(pq.peek() < K) {
            if(pq.size() < 2)
                return (-1);
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + (second * 2));
            answer++;
        }
        
        return answer;
    }
}