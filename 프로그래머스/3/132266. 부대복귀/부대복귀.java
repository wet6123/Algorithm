import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 인접 리스트 생성
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 양방향 그래프 구성
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // destination에서 각 지역까지의 최단 거리 계산 (BFS)
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1); // 초기값을 -1로 설정 (도달 불가능)
        distances[destination] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int next : graph[current]) {
                if (distances[next] == -1) { // 아직 방문하지 않은 지역
                    distances[next] = distances[current] + 1;
                    queue.offer(next);
                }
            }
        }
        
        // 각 부대원의 최단 거리 계산
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = distances[sources[i]];
        }
        
        return answer;
    }
}