import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static String answer;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            long	N = sc.nextLong();
            
            search(N / 2 + 1, 1);
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
    public static void search(long start, int num)
    {
        if (start <= 1)
        {
            if(num % 2 == 0)
                answer = "Alice";
            else
                answer = "Bob";
            return;
        }
        if (num % 2 == 0)
        {
            // win
            search((start + 1) / 2, num + 1);
        }
        else
        {
            // lose
            search(start / 2, num + 1);
        }
    }
}