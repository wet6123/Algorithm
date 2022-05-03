import java.util.Scanner;

//유기농 배추
public class Main {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] map;
	static int cnt;
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();

			map = new boolean[N][M];
			for (int k = 0; k < K; k++) {
				int m = sc.nextInt();
				int n = sc.nextInt();
				
				map[n][m] = true;
			}

			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}

			System.out.println(cnt);
		}
	}

	static void dfs(int y, int x) {
		map[y][x] = false;
		for (int i = 0; i < 4; i++) {
			int n = y + dy[i];
			int m = x + dx[i];
			if(n < 0 || m < 0 || n >= N || m >= M)
				continue;
			if (map[n][m])
				dfs(n, m);
		}
	}
}
