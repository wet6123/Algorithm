class Solution {
    public int minimumObstacles(int[][] grid) {
        // grid 사이즈 측정
        // bfs 돌림
        // 벽 만나면 큐에 벽 추가
        // 도착 못하면 -> 큐에 있는 벽 없애면서 bfs
        // 도착하면 정답 리턴
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int ans = 0;
        int x = grid[0].length;
        int y = grid.length;

        int[][] cnt_map = new int[y][x];
        for(int tmp[]:cnt_map)
            Arrays.fill(tmp, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        cnt_map[0][0] = 0;

        while(q.size() > 0) {
            int[] coor = q.remove();
            int coor_y = coor[0];
            int coor_x = coor[1];
            int cnt = cnt_map[coor_y][coor_x];

            if (coor_x == x - 1 && coor_y == y)
                break;

            for(int i = 0; i < 4; i++) {
                int cur_y = coor_y + dy[i];
                int cur_x = coor_x + dx[i];

                if (cur_x < 0 || cur_x >= x || cur_y < 0 || cur_y >= y)
                    continue;

                if (grid[cur_y][cur_x] == 0) {
                    if (cnt_map[cur_y][cur_x] > cnt) {
                        cnt_map[cur_y][cur_x] = cnt;
                        q.add(new int[] {cur_y, cur_x});
                    }
                } else {
                    if (cnt_map[cur_y][cur_x] > cnt + 1) {
                        cnt_map[cur_y][cur_x] = cnt + 1;
                        q.add(new int[] {cur_y, cur_x});
                    }
                }
            }
        }

        // for(int i = 0; i < y; i++) {
        //     for(int j = 0; j < x; j++) {
        //         if (cnt_map[i][j] == Integer.MAX_VALUE)
        //             System.out.print("x ");
        //         else
        //             System.out.print(cnt_map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return cnt_map[y - 1][x - 1];
    }
}