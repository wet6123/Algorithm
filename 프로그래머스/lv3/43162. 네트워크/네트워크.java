class Solution {
    static int N;
    static int[] map;
    static int[][] com;
    public int solution(int n, int[][] computers) {
        N = n;
        map = new int[n];
        com = computers;
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(map[i] == 0) {
                cnt++;
                dfs(i, cnt);
            }
        }
        
        return cnt;
    }
    public static void dfs(int idx, int mark) {
        map[idx] = mark;
        for(int i = 0; i < N; i++) {
            if(com[idx][i] == 1 && map[i] == 0) {
                dfs(i, mark);
            }
        }
    }
}