class Solution {
    public int[] solution(int n, int s) {
        if (n > s)
            return new int[] {-1};
        int[] answer = new int[n];
        int init = s / n;
        int left = s % n;
        for(int i = n - 1; i >= 0; i--) {
            if (left > 0) {
                answer[i] = init + 1;
            } else {
                answer[i] = init;
            }
            left--;
        }
        return answer;
    }
}