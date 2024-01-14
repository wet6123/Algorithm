import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Solution
{
    static Set<Integer> set = new HashSet<Integer>();
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            set.clear();
			int	N = sc.nextInt();
            int[] arr = new int[101];
            
            set.add(0);
            for(int i = 0; i < N; i++)
            {
                find(sc.nextInt());
            }
            int ans = set.size();
            System.out.println("#" + test_case + " " + ans);
		}
        sc.close();
	}
    static void find(int num)
    {
        Set<Integer> tmpSet = new HashSet<Integer>();
        tmpSet.addAll(set);
        Iterator<Integer> it = tmpSet.iterator();
        while(it.hasNext())
            set.add(it.next() + num);
    }
}