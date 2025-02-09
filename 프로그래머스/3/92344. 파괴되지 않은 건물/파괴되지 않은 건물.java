class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] prefixSum = new int[n + 1][m + 1];
        
        // 각 스킬의 영향을 누적합 배열의 모서리에만 표시
        for (int[] s : skill) {
            int type = s[0], r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4], degree = s[5];
            int value = (type == 1) ? -degree : degree;
            
            prefixSum[r1][c1] += value;
            prefixSum[r1][c2 + 1] -= value;
            prefixSum[r2 + 1][c1] -= value;
            prefixSum[r2 + 1][c2 + 1] += value;
        }
        
        // 가로 방향 누적합 계산
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefixSum[i][j] += prefixSum[i][j-1];
            }
        }
        
        // 세로 방향 누적합 계산
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                prefixSum[i][j] += prefixSum[i-1][j];
            }
        }
        
        // 최종 결과 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + prefixSum[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}