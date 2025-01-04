class Solution {
    static int[] d;
    static boolean[] v;
    static int[][] map;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = 100000000;
            }
        }
        for(int i = 0; i < fares.length; i++) {
            int idx_1 = fares[i][0] - 1;
            int idx_2 = fares[i][1] - 1;
            int fare = fares[i][2];
            map[idx_1][idx_2] = fare;
            map[idx_2][idx_1] = fare;
        }
        
        int[] ds = Daijkstra(n, s - 1);
        int[] da = Daijkstra(n, a - 1);
        int[] db = Daijkstra(n, b - 1);

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int sum = ds[i] + da[i] + db[i];
            if (sum < answer)
                answer = sum;
        }
        
        return answer;
    }
    
    public int[] Daijkstra(int n, int start) {
        d = new int[n];
        v = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            d[i] = map[start][i];
        }
        
        d[start] = 0;
        v[start] = true;
        for(int i = 0; i < n - 2; i++) {
            int index = getSmallIndex(n);
            v[index] = true;
            for(int j = 0; j < n; j++) {
                if (!v[j]) {
                    if (d[index] + map[index][j] < d[j]) {
                        d[j] = d[index] + map[index][j];
                    }
                }
            }
        }
        
        return d;
    }
    
    public int getSmallIndex(int n) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < n; i++) {
            if (d[i] < min && !v[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }
}