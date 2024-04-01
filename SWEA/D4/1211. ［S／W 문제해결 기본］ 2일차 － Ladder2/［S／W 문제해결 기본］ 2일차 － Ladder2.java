import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[][] map, visited;
    static int len, ans;
    static int[] dx = {1, -1, 0};
    static int[] dy = {0, 0, -1};
	public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            sc.nextInt();
            map = new int[100][100];
            
            for(int i = 0; i < 100; i++)
            {
                for(int j = 0; j < 100; j++)
                {
                    map[i][j] = sc.nextInt();
                }
            }
            
            len = Integer.MAX_VALUE;
            ans = 0;
            
            for(int i = 0; i < 100; i++)
            {
                if (map[99][i] == 1)
                {
                    visited = new int[100][100];
            		search(i, 99, 0);
                }
            }
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
    public static void search(int x, int y, int cnt)
    {
        visited[y][x] = 1;
        if (y == 0)
        {
            if (len > cnt)
            {
                ans = x;
                len = cnt;
            }
            return ;
        }
        for(int i = 0; i < 3; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && map[ny][nx] == 1 && visited[ny][nx] != 1)
            {
                search(nx, ny, cnt+1);
                break;
            }
        }
    }
}