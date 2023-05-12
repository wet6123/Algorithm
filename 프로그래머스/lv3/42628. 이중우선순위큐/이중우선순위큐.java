import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = operations.length;
        for(int i = 0; i < len; i++) {
            String now = operations[i];
            if(now.charAt(0) == 'I') {
                int strLen = now.length();
                int sign = 1;
                int num = 0;
                int idx = 2;
                if(now.charAt(idx) == '-') {
                    sign *= (-1);
                    idx++;
                }
                while(idx < strLen) {
                    num *= 10;
                    num += now.charAt(idx) - '0';
                    idx++;
                }
                num *= sign;
                pq.add(num);
            } else if(now.charAt(0) == 'D') {
                if(now.charAt(2) == '-') {
                    pq.poll();
                } else {
                    PriorityQueue<Integer> tmp = new PriorityQueue<>((o1, o2) -> o2 - o1);
                    while(pq.size() > 0) {
                        tmp.add(pq.poll());
                    }
                    tmp.poll();
                    pq.clear();
                    while(tmp.size() > 0) {
                        pq.add(tmp.poll());
                    }
                }
            }
        }
        int[] answer = new int[2];
        if(pq.size() > 1)
            answer[1] = pq.poll();
        while(pq.size() > 1) {
            pq.poll();
        }
        if(pq.size() > 0)
            answer[0] = pq.poll();
        return answer;
    }
}