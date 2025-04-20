import java.util.*;

class Solution {
    private int[] visited;
    private List<Integer>[] edges;
    
    public int[] solution(int[] nodes, int[][] edges_) {
        // 최대 노드 번호 찾기
        int maxNode = 0;
        for (int node : nodes) {
            maxNode = Math.max(maxNode, node);
        }
        
        // 방문 배열 및 간선 정보 초기화
        visited = new int[maxNode + 1];
        Arrays.fill(visited, -1);
        
        edges = new ArrayList[maxNode + 1];
        for (int i = 0; i <= maxNode; i++) {
            edges[i] = new ArrayList<>();
        }
        
        // 간선 정보 저장
        for (int[] edge : edges_) {
            int a = edge[0];
            int b = edge[1];
            edges[a].add(b);
            edges[b].add(a);
        }
        
        int[] ans = {0, 0};
        
        // 각 트리(연결 컴포넌트)에 대해 처리
        for (int node : nodes) {
            if (visited[node] != -1) continue;
            
            int[] arr = {0, 0};
            dfs(node, -1, arr);
            
            if ((arr[0] == 0 && arr[1] == 2) || (arr[0] == 2 && arr[1] == 0)) {
                ans[0] += 1;
                ans[1] += 1;
            } else if (arr[0] == 0) {
                ans[1] += 1;
            } else if (arr[1] == 0) {
                ans[0] += 1;
            } else if (arr[0] == 2 && visited[node] == 0) {
                ans[1] += 1;
            } else if (arr[1] == 2 && visited[node] == 1) {
                ans[0] += 1;
            }
        }
        
        return ans;
    }
    
    private void dfs(int cur, int prev, int[] arr) {
        int cnt = 0;
        
        for (int nxt : edges[cur]) {
            if (nxt == prev) continue;
            dfs(nxt, cur, arr);
            cnt++;
        }
        
        visited[cur] = (cur % 2 + cnt % 2) % 2;
        arr[visited[cur]]++;
    }
}