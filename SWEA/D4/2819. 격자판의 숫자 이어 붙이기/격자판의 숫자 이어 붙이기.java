import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Set;
import java.util.HashSet;

class Solution
{
    static int[] dx = {0, 1 ,0 ,-1};
    static int[] dy = {1, 0, -1, 0};
    static Set<Integer> set = new HashSet<>();
    static String[][] map;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            set.clear();
            map = new String[4][4];
			for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    map[i][j] = sc.next();
                }
            }
            for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 4; j++)
                {
                     search(0, "", i, j);
                }
            }
            int ans = set.size();
            System.out.println("#" + test_case + " " + ans);
		}
        sc.close();
	}
    static void search(int cnt, String str, int x, int y)
    {
        if (cnt >= 7)
        {
            set.add(Integer.parseInt(str));
            return;
        }
        for(int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4)
            	search(cnt + 1, str + map[nx][ny], nx, ny);
        }
    }
}