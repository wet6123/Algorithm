class Solution {
    public int solution(int n, int[] stations, int w) {
        int start = 1, end = 1, answer = 0;
        
        for(int num : stations) {
            end = num - w - 1;
            if (start <= end) {
                answer += (end - start + 1) / (2 * w + 1);
                if ((end - start + 1) % (2 * w + 1) > 0) answer++;
            }
            start = num + w + 1;
        }
        
        if (start <= n) {
            answer += Math.ceil((double)(n - start + 1) / (2 * w + 1));
        }
        
        return answer;
    }
}