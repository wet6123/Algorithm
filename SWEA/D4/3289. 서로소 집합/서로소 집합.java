import java.util.Scanner;

//서로소 집합
public class Solution {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			System.out.print("#" + (tc+1) + " ");
			int N = sc.nextInt();
			int M = sc.nextInt();

			p = new int[N+1];
			
			for (int i = 1; i < N+1; i++)
				makeset(i);

			for (int m = 0; m < M; m++) {
				int act = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(act == 0) {
					union(x, y);
				}
				else if(act == 1) {
					if(findset(x) == findset(y))
						System.out.print(1);
					else
						System.out.print(0);
				}
			}
			System.out.println();
		}
	}

	static void makeset(int idx) {
		p[idx] = idx;
	}

	static int findset(int idx) {
		if (p[idx] != idx)
			p[idx] = findset(p[idx]);
		return p[idx];
	}

	static void union(int x, int y) {
		p[findset(x)] = findset(y);
	}
}
