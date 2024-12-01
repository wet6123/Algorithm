class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        // 거리 배열 초기화
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // 우선순위 큐 사용 - [y, x, 제거한 장애물 수]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        distance[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int y = current[0], x = current[1], obstacles = current[2];
            
            // 이미 더 좋은 경로를 찾았다면 스킵
            if (obstacles > distance[y][x]) continue;
            
            // 목적지에 도달했다면 결과 반환
            if (y == m-1 && x == n-1) return obstacles;
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                
                int newObstacles = obstacles + grid[ny][nx];
                
                // 더 적은 장애물을 제거하고 도달할 수 있다면 갱신
                if (newObstacles < distance[ny][nx]) {
                    distance[ny][nx] = newObstacles;
                    pq.offer(new int[]{ny, nx, newObstacles});
                }
            }
        }
        
        return distance[m-1][n-1];
    }
}