import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String str = sc.next();
            int len = str.length();
            char tmp = '0';
            int ans = 0;
            
            for(int i = 0; i< len; i++)
            {
                if(str.charAt(i) != tmp)
                {
                    ans++;
                    tmp = str.charAt(i);
                }
            }
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
}