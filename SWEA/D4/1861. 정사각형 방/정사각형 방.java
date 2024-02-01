import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int ans;
    static int max_cnt;
    static int N;
    static int[][] map;
    static int[] di = {0, 0, 1, -1};
    static int[] dj = {1, -1, 0, 0};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans = 1001;
            max_cnt = 0;
            N = sc.nextInt();
            map = new int[N][N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    map[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                	search(i, j, 1, map[i][j]);
                }
            }
            System.out.println("#" + test_case + " " + ans + " " + max_cnt);
		}
	}
    public static void search(int i, int j, int cnt, int num)
    {
        int flag = 0;
        for (int k = 0; k < 4; k++)
        {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >=0 && ni < N && nj >= 0 && nj < N && map[i][j] + 1 == map[ni][nj])
            {
                flag = 1;
                search(ni, nj, cnt + 1, num);
            }
        }
        if (flag == 0)
        {
            if (max_cnt < cnt || (max_cnt == cnt && ans > num))
            {
                ans = num;
                max_cnt = cnt;
            }
            return ;
        }
    }
}