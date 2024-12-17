class Solution {
    static int[][] connectionInfo;
    static boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        connectionInfo = isConnected;
        visited = new boolean[isConnected.length];
        int ans = 0;

        for(int i = 0; i < isConnected.length; i++) {
            for(int j = 0; j < isConnected[i].length; j++) {
                if (!visited[i]  && connectionInfo[i][j] == 1) {
                    ans++;
                    dfs(j);
                }
            }
        }

        return ans;
    }
    public void dfs(int idx) {
        visited[idx] = true;
        for(int i = 0; i < connectionInfo[idx].length; i++) {
            if (!visited[i] && connectionInfo[idx][i] == 1) {
                dfs(i);
            }
        }
    }
}