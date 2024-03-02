import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] idx;
    static int ans;
    static int N;
    static int[] dx = {-1, 0, 1};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
            ans = 0;
            
            idx = new int[N];
            search(0);
            
            System.out.println("#" + test_case + " " + ans);
		}
	}
    public static void search(int row)
    {
        if (row == N)
        {
            ans++;
            return ;
        }
        all: for(int col = 0; col < N; col++)
        {
            for(int i = 0; i < row; i++)
            {
                int drow = row - i;
                drow = drow * drow;
                int dcol = col - idx[i];
                dcol = dcol * dcol;
                if (dcol == 0 || drow == dcol)
                {
                    continue all;
                }
            }
            idx[row] = col;
            search(row + 1);
        }
    }
}