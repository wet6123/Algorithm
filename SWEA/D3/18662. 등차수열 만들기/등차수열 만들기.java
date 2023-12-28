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
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int sum = a + b + c;
            float k = sum - 3 * a - 3 * (c - b);
            if (k < 0)
                k *= -1;
            System.out.println("#" + test_case + " " + k / 4);
		}
	}
}