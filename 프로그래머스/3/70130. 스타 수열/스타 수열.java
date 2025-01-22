import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] a) {
        int len = a.length;
        Queue<Integer>[] index = new LinkedList[len];
        for(int i = 0; i < len; i++) {
            index[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < len; i++) {
            int num = a[i];
            index[num].offer(i);
        }
        
        int answer = 0;
        
        for(int i = 0; i < len; i++) {
            int size = index[i].size();
            if (size > 0 && size * 2 > answer) {
                int cnt = 0;
                boolean[] selected = new boolean[len];
                for(int j = 0; j < size; j++) {
                    int idx = index[i].poll();
                    selected[idx] = true;
                    if (idx > 0 && a[idx - 1] != i && !selected[idx - 1]) {
                        selected[idx - 1] = true;
                        cnt++;
                    } else if (idx + 1 < len && a[idx + 1] != i && !selected[idx + 1]) {
                        selected[idx + 1] = true;
                        cnt++;
                    }
                }
                answer = Math.max(answer, cnt * 2);
            }
        }
        
        return answer;
    }
}