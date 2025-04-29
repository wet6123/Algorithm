import java.util.ArrayList;
import java.util.List;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Integer> collatzSequence = calculateCollatzSequence(k);
        int n = collatzSequence.size() - 1;
        
        double[] areaSums = new double[n];
        for (int i = 0; i < n; i++) {
            double area = (collatzSequence.get(i) + collatzSequence.get(i + 1)) / 2.0;
            if (i > 0) {
                areaSums[i] = areaSums[i - 1] + area;
            } else {
                areaSums[i] = area;
            }
        }
        
        double[] result = new double[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = n + ranges[i][1];
            
            if (start > end) {
                result[i] = -1.0;
                continue;
            }
            
            double startArea = (start > 0) ? areaSums[start - 1] : 0;
            double endArea = (end > 0) ? areaSums[end - 1] : 0;
            result[i] = endArea - startArea;
        }
        
        return result;
    }
    
    private List<Integer> calculateCollatzSequence(int k) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(k);
        
        long current = k;
        while (current > 1) {
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = current * 3 + 1;
            }
            
            sequence.add((int) current);
        }
        
        return sequence;
    }
}