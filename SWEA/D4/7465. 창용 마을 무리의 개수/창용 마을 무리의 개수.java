import java.util.Scanner;

//창용 마을 무리의 개수
public class Solution {
	static int[] arr;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			arr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				make(i);
			}

			for (int m = 0; m < M; m++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x, y);
			}

			ans = 0;

			for (int i = 1; i <= N; i++) {
				if (i == arr[i]) {
					ans++;
				}
			}
			System.out.println("#" + (tc + 1) + " " + ans);
		}
	}

	static void make(int x) {
		arr[x] = x;
	}
	static int find(int x) {
		if (x == arr[x])
			return x;
		else
			return find(arr[x]);
	}

	static void union(int x, int y) {
		arr[find(y)] = find(x);
	}
}
