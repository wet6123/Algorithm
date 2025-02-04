class Solution {
    static int cnt;
    static boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        visited = new boolean[size];
        cnt = size;

        dfs(0, rooms);

        return cnt == 0 ? true : false;
    }
    
    private void dfs(int idx, List<List<Integer>> rooms) {
        if (visited[idx])
            return;
        
        visited[idx] = true;
        cnt--;

        List<Integer> keys = rooms.get(idx);
        for(int key : keys) {
            dfs(key, rooms);
        }
    }
}