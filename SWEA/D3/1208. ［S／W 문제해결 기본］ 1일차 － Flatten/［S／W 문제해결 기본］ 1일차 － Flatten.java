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
            int dump = sc.nextInt();
            int[] arr = new int[101];
            for (int i = 0; i < 100; i++)
            {
                arr[sc.nextInt()]++;
            }
            
            int min = 0;
            int up = dump;
            for (int i = 0; i <= 99; i++)
            {
                if (up >= arr[i])
                {
                    up -= arr[i];
                    arr[i + 1] += arr[i];
                    arr[i] = 0;
                }
                else
                {
                    arr[i] -= up;
                    arr[i + 1] = up;
                    up = 0;
                    min = i;
                    break;
                }
            }
            
            int max = 0;
            int down = dump;
            for (int i = 100; i >= 1; i--)
            {
                if (down >= arr[i])
                {
                    down -= arr[i];
                    arr[i - 1] += arr[i];
                    arr[i] = 0;
                }
                else
                {
                    arr[i] -= down;
                    arr[i - 1] += down;
                    down = 0;
                    max = i;
                    break;
                }
            }
            int ans = max - min;
			System.out.println("#" + test_case + " " + ans);
		}
	}
}