import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[][] map;
    static int N, b_cnt, w_cnt;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            int M = sc.nextInt();
            
            map = new int[N][N];
            
            map[N / 2][N / 2] = 2;
            map[N / 2 - 1][N / 2 - 1] = 2;
            map[N / 2][N / 2 - 1] = 1;
            map[N / 2 - 1][N / 2] = 1;

            for(int i = 0; i < M; i++)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int color = sc.nextInt();
                set_stone(x - 1, y - 1, color);
            }
            
            b_cnt = 0;
            w_cnt = 0;
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if (map[j][i] == 1)
                        b_cnt++;
                    else if (map[j][i] == 2)
                        w_cnt++;
                }
            }
            
            System.out.println("#" + test_case + " " + b_cnt + " " + w_cnt);
		}
	}
    public static void set_stone(int x, int y, int color)
    {
        map[y][x] = color;
        for(int i = 0; i < 8; i++)
        {
            int nx =  x + dx[i];
            int ny =  y + dy[i];
            int cnt = 1;
            boolean change = false;
            while(nx >= 0 && ny >= 0 && nx < N && ny < N)
            {
                if (map[ny][nx] == color)
                {
                    change = true;
                    break;
                }
                else if (map[ny][nx] == 0)
                    break;
                cnt++;
				nx = x + dx[i] * cnt;
                ny = y + dy[i] * cnt;
            }
            if (change == true)
            {
            	change_color(x, y, dx[i], dy[i], color);
            }
        }
    }
    public static void change_color(int x, int y, int n_dx, int n_dy, int color)
    {
        int nx =  x + n_dx;
        int ny =  y + n_dy;
        int cnt = 1;
        while(nx >= 0 && ny >= 0 && nx < N && ny < N)
        {
            if (map[ny][nx] == color)
            	break;
            map[ny][nx] = color;
            cnt++;
            nx = x + n_dx * cnt;
            ny = y + n_dy * cnt;
        }
    }
}