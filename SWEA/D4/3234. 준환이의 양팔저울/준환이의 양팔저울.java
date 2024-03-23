import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int ans;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] nums = new int[N];
            int[] selected = new int[N];
            int sum = 0;
            ans = 0;
            
            for(int i = 0; i < N; i++)
            {
                nums[i] = sc.nextInt();
                sum += nums[i];
            }
            
            search(0, 0, 0, sum, selected, nums, N);
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
    public static void search(int left, int right, int cnt, int left_sum, int[] selected, int[] nums, int N)
    {
        if (right - left > left_sum || right > left)
            return;
        if (cnt == N)
        {
            ans++;
            return;
        }
        for(int i = 0; i < N; i++)
        {
            if (selected[i] == 0)
            {
                selected[i] = 1;
                search(left + nums[i], right, cnt + 1, left_sum - nums[i], selected, nums, N);
                search(left, right + nums[i], cnt + 1, left_sum - nums[i], selected, nums, N);
                selected[i] = 0;
            }
        }
    }
}