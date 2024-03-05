import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int cmp_num;
    static int max_cal;
    static int[][] cmps;
    static int ans;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            cmp_num = sc.nextInt();
            max_cal = sc.nextInt();
            
            cmps = new int[cmp_num][2];
            for(int i = 0; i < cmp_num; i++)
            {
                cmps[i][0] = sc.nextInt();
                cmps[i][1] = sc.nextInt();
            }
            ans = 0;
            
            search(0, 0, 0);
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
    public static void search(int cnt, int now_score, int now_cal)
    {
        if (now_cal > max_cal)
            return ;
        if (cnt == cmp_num)
        {
            if (ans < now_score && max_cal >= now_cal)
            {
                ans = now_score;
            }
            return ;
        }
        
        search(cnt + 1, now_score + cmps[cnt][0], now_cal + cmps[cnt][1]);
        search(cnt + 1, now_score, now_cal);
    }
}