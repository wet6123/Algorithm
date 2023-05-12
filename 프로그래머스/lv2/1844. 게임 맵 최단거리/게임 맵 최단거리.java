import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] ans;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int m;
    static int n;
    public class Node {
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static Queue<Node> q;
    public int solution(int[][] maps) {
        q = new LinkedList<>();
        map = maps;
        m = maps[0].length;
        n = maps.length;
        
        ans = new int[n][m];
        
        q.add(new Node(0, 0, 1));
        while(q.size() > 0) {
            Node tmp = q.poll();
            bfs(tmp.x, tmp.y, tmp.cnt);
        }

        int answer = ans[n-1][m-1];
        if(answer == 0)
            answer = -1;
        return answer;
    }
    public void bfs(int x, int y, int cnt) {
        if(ans[x][y] == 0)
            ans[x][y] = cnt;
        else
            return;
        if(ans[n-1][m-1] != 0) {
            q.clear();
            return;
        }
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            
            if (mx >= 0 && my >= 0 && mx < n && my < m) {
                if(map[mx][my] == 1 && ans[mx][my] == 0)
                    q.add(new Node(mx, my, cnt+1));
            }
        }
    }
}