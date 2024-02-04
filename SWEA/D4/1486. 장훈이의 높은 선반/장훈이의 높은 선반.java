import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int N;
    static int B;
    static int[] height;
    static int ans;
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            B = sc.nextInt();
            height = new int[N];
            for(int i = 0; i < N; i++)
            {
                height[i] = sc.nextInt();
            }
            
            ans = Integer.MAX_VALUE;
            
            search(0, 0);
            
            System.out.print("#" + test_case + " " + ans + "\n");
		}
	}
    public static void search(int sum, int cnt)
    {
        if (cnt == N)
        {
            if (sum >= B && sum - B < ans)
            {
                ans = sum - B;
            }
            return ;
        }
        search(sum, cnt + 1);
        search(sum + height[cnt], cnt + 1);
    }
}