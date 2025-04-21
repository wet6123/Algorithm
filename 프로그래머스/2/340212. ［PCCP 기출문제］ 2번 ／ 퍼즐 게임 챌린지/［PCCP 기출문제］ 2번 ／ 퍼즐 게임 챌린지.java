import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();
        
        while (start < end) {
            int mid = (start + end) / 2;
            
            if (canSolveAllPuzzles(diffs, times, mid, limit)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
    
    private boolean canSolveAllPuzzles(int[] diffs, int[] times, int level, long limit) {
        long totalTime = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            int diff = diffs[i];
            int time_cur = times[i];
            int time_prev = (i > 0) ? times[i - 1] : 0;
            
            if (diff <= level) {
                totalTime += time_cur;
            } else {
                int mistakes = diff - level;
                long mistakeTime = (long)(time_cur + time_prev) * mistakes;
                totalTime += mistakeTime + time_cur;
            }
            
            if (totalTime > limit) {
                return false;
            }
        }
        
        return true;
    }
}