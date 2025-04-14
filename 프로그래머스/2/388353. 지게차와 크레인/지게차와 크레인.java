class Solution {
    // 상하좌우 이동을 위한 방향 배열
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        
        // (n+2) x (m+2) 크기의 배열 생성 (테두리는 빈 공간)
        char[][] warehouse = new char[n + 2][m + 2];
        
        // 테두리를 '.' (빈 공간)으로 초기화
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                warehouse[i][j] = '.';
            }
        }
        
        // storage 데이터를 warehouse에 채움
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                warehouse[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        
        // 각 출고 요청 처리
        for (String request : requests) {
            char containerType = request.charAt(0);
            
            if (request.length() == 1) {
                // 지게차 사용 (접근 가능한 컨테이너만 제거)
                removeAccessibleContainers(warehouse, containerType);
            } else {
                // 크레인 사용 (모든 해당 컨테이너 제거)
                removeAllContainers(warehouse, containerType);
            }
        }
        
        // 남은 컨테이너 수 계산
        int remainingContainers = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (warehouse[i][j] != '.') {
                    remainingContainers++;
                }
            }
        }
        
        return remainingContainers;
    }
    
    // 접근 가능한 컨테이너 제거 (지게차)
    private void removeAccessibleContainers(char[][] warehouse, char containerType) {
        int n = warehouse.length - 2;
        int m = warehouse[0].length - 2;
        
        // 외부와 연결된 빈 공간 표시를 위한 방문 배열
        boolean[][] visited = new boolean[n + 2][m + 2];
        
        // 테두리에서 DFS 시작 (외부 빈 공간 탐색)
        markExternalSpace(warehouse, visited);
        
        // 외부 빈 공간과 인접한 대상 컨테이너 제거
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (warehouse[i][j] == containerType) {
                    // 인접한 셀 중 하나라도 외부 빈 공간이면 접근 가능
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (visited[nx][ny]) {
                            warehouse[i][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
    
    // 외부와 연결된 빈 공간 표시 (테두리에서 시작하는 DFS)
    private void markExternalSpace(char[][] warehouse, boolean[][] visited) {
        int n = warehouse.length - 2;
        int m = warehouse[0].length - 2;
        
        // DFS 시작은 테두리에서만
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= m + 1; j++) {
                if ((i == 0 || i == n + 1 || j == 0 || j == m + 1) && warehouse[i][j] == '.') {
                    dfs(warehouse, visited, i, j);
                }
            }
        }
    }
    
    // DFS로 외부 빈 공간 탐색
    private void dfs(char[][] warehouse, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 배열 범위 내이고, 방문하지 않은 빈 공간인 경우
            if (nx >= 0 && nx < warehouse.length && ny >= 0 && ny < warehouse[0].length 
                && !visited[nx][ny] && warehouse[nx][ny] == '.') {
                dfs(warehouse, visited, nx, ny);
            }
        }
    }
    
    // 모든 대상 컨테이너 제거 (크레인)
    private void removeAllContainers(char[][] warehouse, char containerType) {
        for (int i = 1; i < warehouse.length - 1; i++) {
            for (int j = 1; j < warehouse[0].length - 1; j++) {
                if (warehouse[i][j] == containerType) {
                    warehouse[i][j] = '.';
                }
            }
        }
    }
}