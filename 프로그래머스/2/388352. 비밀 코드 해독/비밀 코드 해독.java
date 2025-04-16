import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static List<int[]> combinations;
    public int solution(int n, int[][] q, int[] ans) {
        int result = 0;
        
        combinations = new ArrayList<>();
        getCombinations(1, n, new int[5], 0, 0);
        
        for (int[] combination : combinations) {
            boolean isValid = true;
            
            for (int i = 0; i < q.length; i++) {
                int matches = countMatches(combination, q[i]);
                
                if (matches != ans[i]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result++;
            }
        }
        
        return result;
    }
    
    private void getCombinations(int start, int end, int[] combination, int idx, int depth) {
        if (depth == 5) {
            combinations.add(Arrays.copyOf(combination, 5));
            return;
        }
        
        for (int i = start; i <= end; i++) {
            combination[idx] = i;
            getCombinations(i + 1, end, combination, idx + 1, depth + 1);
        }
    }
    
    private int countMatches(int[] code, int[] attempt) {
        int count = 0;
        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < attempt.length; j++) {
                if (code[i] == attempt[j]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}