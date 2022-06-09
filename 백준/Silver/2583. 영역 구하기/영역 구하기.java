import java.util.Arrays;
import java.util.Scanner;

//영역 구하기
public class Main {
	static int[] ans;
	static boolean[][] map;
	static int cnt = 0;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int M;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int K = sc.nextInt();

		map = new boolean[M][N];

		for (int k = 0; k < K; k++) {
			int lx = sc.nextInt();
			int ly = sc.nextInt();
			int rx = sc.nextInt();
			int ry = sc.nextInt();

			for (int x = lx; x < rx; x++) {
				for (int y = ly; y < ry; y++) {
					map[y][x] = true;
				}
			}
		}

		int max = (K * K + K + 1) / 2;
		ans = new int[max];

		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (!map[y][x]) {
					DFS(x, y);
					cnt++;
				}
			}
		}
		int areas = 0;
		for(int i = 0; i < max; i++) {
			if(ans[i] == 0)
				break;
			areas++;
		}
		Arrays.sort(ans);
		
		System.out.println(areas);
		for(int i = max-areas; i < max; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	static void DFS(int x, int y) {
		ans[cnt]++;
		map[y][x] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			if(!map[ny][nx])
				DFS(nx, ny);
		}
	}
}
