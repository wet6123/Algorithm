import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] dx  = {0, 0, 1, -1};
    static int[] dy  = {1, -1, 0, 0};
    static int ans;
    static int[][] map;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            sc.nextInt();
            map = new int[16][16];
            int x = 0;
            int y = 0;
            for(int i = 0; i < 16; i++)
            {
                String str = sc.next();
                for(int j = 0; j < 16; j++)
                {
                    map[i][j] = str.charAt(j) - '0';
                    if (map[i][j] == 2)
                    {
                    	x = j;
                    	y = i;
                    }
                }
            }
            ans = 0;
            search(x, y);
            System.out.println("#" + test_case + " " + ans);
		}
	}
    static void search(int x, int y)
    {
        if (map[x][y] == 3)
        {
            ans = 1;
            return;
        }
        for(int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16)
            {
                if (map[ny][nx] == 0 || map[ny][nx] == 3)
                {
                    if(map[ny][nx] == 0)
                    	map[ny][nx] = 2;
                    search(nx, ny);
                }
            }
        }
    }
}