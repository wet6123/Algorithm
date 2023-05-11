import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> work = new LinkedList<>();
        int len = progresses.length;
        for(int i = 0; i < len; i++) {
            work.add((100-progresses[i] + speeds[i] - 1) / speeds[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        int num = 0;
        int cnt = 0;
        while(work.size() > 0) {
            int tmp = work.poll();
            if(num < tmp) {
                num = tmp;
                if(cnt != 0)
                    res.add(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        res.add(cnt);
        int[] answer = new int[res.size()];
        int i = 0;
        for(int number : res)
            answer[i++] = number;
        return answer;
    }
}