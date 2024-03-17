import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            sc.nextInt();
            int[] sum = new int[202];
            for(int i = 0; i < 100; i++)
            {
                for(int j = 0; j < 100; j++)
                {
                    int tmp = sc.nextInt();
                    sum[j] += tmp;
                    sum[100 + i] += tmp;
                    if (i == j)
                    {
                        sum[200] += tmp;
                    }
                    if (i + j == 99)
                    {
                        sum[201] += tmp;
                    }
                }
            }
            int ans = 0;
            for(int i = 0; i < 202; i++)
            {
                if (ans < sum[i])
                    ans = sum[i];
            }
            System.out.println("#" + test_case + " " + ans);
		}
	}
}