import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
        T = 10;

		for (int test_case = 1; test_case <= T; test_case++)
		{
            int size = sc.nextInt();
			int[] map = new int[size];
            int ans = 0;
            for (int i = 0; i < size; i++)
            {
                map[i] = sc.nextInt();
            }
            for (int i = 2; i < size - 2; i++)
            {
                int max = 0;
                for (int j = -2; j <= 2; j++)
                {
                    if (j != 0 && max < map[i + j])
                        max = map[i + j];
                }
                if (max < map[i])
                {
                    ans += map[i] - max;
                }
            }
            System.out.println("#" + test_case + " " + ans);
		}
	}
}