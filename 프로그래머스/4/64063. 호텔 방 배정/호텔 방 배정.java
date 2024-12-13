import java.util.HashMap; 
import java.util.LinkedList;

class Solution {
    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        HashMap<Long, Long> next_empty_idx = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            LinkedList<Long> idx_chain = new LinkedList<>();
            long idx = room_number[i];
            while(next_empty_idx.containsKey(idx)) {
                idx_chain.add(idx);
                idx = next_empty_idx.get(idx);
            }
            answer[i] = idx;
            next_empty_idx.put(idx, idx + 1);
            while(idx_chain.size() != 0) {
                next_empty_idx.put(idx_chain.removeFirst(), idx + 1);
            }
        }
        
        return answer;
    }
}