
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
    static int[][][][] visited;
    static int ans;
    static int R;
    static int C;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			R = sc.nextInt();
            C = sc.nextInt();
            map = new char[R][C];
            visited = new int[R][C][16][4];
            String tmp;
            ans = 0;
            int endable = 0;
            for (int i = 0; i < R; i++) {
                tmp = sc.next();
                for (int j = 0; j < C; j++) {
               		map[i][j] = tmp.charAt(j);
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '@')
                    {
                    	endable = 1;
                    	int cnt = 0;
                    	for (int k = 0; k < 4; k++)
                    	{
                    		int ni = i + dx[k];
                    		int nj = j + dy[k];
                    		if (ni >= 0 && ni < R && nj >= 0 && nj < C)
                    		{
                    			char now = map[ni][nj];
                    			if (now == '>' || now == '<' || now == '^' || now == 'v')
                    				cnt++;
                    		}
                    	}
                    	if (cnt == 4)
                    		endable = 0;
                    }
                }
            }
            if (endable == 1)
            	search(0, 0, 0, 2);
            System.out.print("#" + test_case + " ");
            if (ans == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
		}
	}
    static void search(int x, int y, int mem, int dir) {
    	if (visited[x][y][mem][dir] == 1)
            return;
        visited[x][y][mem][dir] = 1;
        int nx = x;
        int ny = y;
        if (map[x][y] == '@') {
            ans = 1;
            return ;
        }
        else if (map[x][y] == '<') {
            dir = 3;
        }
        else if (map[x][y] == '>') {
            dir = 2;
        }
        else if (map[x][y] == '^') {
            dir = 1;
        }
        else if (map[x][y] == 'v') {
            dir = 0;
        }
        else if (map[x][y] == '_') {
            if (mem == 0)
                dir = 2;
            else
                dir = 3;
        }
        else if (map[x][y] == '|') {
            if (mem == 0)
                dir = 0;
            else
                dir = 1;
        }
        else if (map[x][y] == '?') {
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
       			ny = y + dy[i];
                if (nx > R - 1)
            		nx = 0;
                if (nx < 0)
                    nx = R - 1;
                if (ny > C - 1)
                    ny = 0;
                if (ny < 0)
                    ny = C - 1;
                search(nx, ny, mem, i);
            }
            return;
        }
        else if (map[x][y] >= '0' && map[x][y] <= '9') {
            mem = map[x][y]  - '0';
        }
        else if (map[x][y] == '+') {
            mem++;
            if (mem > 15)
                mem = 0;
        }
        else if (map[x][y] == '-') {
            mem--;
            if (mem < 0)
                mem = 15;
        }
        nx = x + dx[dir];
        ny = y + dy[dir];
        if (nx > R - 1)
            nx = 0;
        if (nx < 0)
            nx = R - 1;
        if (ny > C - 1)
            ny = 0;
        if (ny < 0)
            ny = C - 1;
        search(nx, ny, mem, dir);
    }
}