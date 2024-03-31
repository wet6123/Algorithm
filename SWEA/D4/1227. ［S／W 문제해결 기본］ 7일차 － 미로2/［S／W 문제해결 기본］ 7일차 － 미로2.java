import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int ans;
    static int end_x;
    static int end_y;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            ans = 0;
            int start_x = 0;
            int start_y = 0;
            sc.nextInt();
            map = new int[100][100];
            for(int i = 0; i < 100; i++)
            {
                String tmp = sc.next();
                for(int j = 0; j < 100; j++)
                {
                    map[i][j] = tmp.charAt(j) - '0';
                    if (map[i][j] == 2)
                    {
                        start_x = j;
                        start_y = i;
                    }
                    if (map[i][j] == 3)
                    {
                        end_x = j;
                        end_y = i;
                    }
                }
            }
            
            search(start_x, start_y);
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
    public static void search(int x, int y)
    {
        if (end_x == x && end_y == y)
        {
            ans = 1;
            return;
        }
        for(int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && map[ny][nx] != 1 && ans != 1)
            {
                map[ny][nx] = 1;
                search(nx, ny);
            }
        }
    }
}