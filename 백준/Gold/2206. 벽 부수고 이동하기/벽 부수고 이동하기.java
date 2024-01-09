import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//벽 부수고 이동하기
public class Main {
	static class idx {
		int n, m, cnt, b;

		public idx(int n, int m, int cnt, int b) {
			this.n = n;
			this.m = m;
			this.cnt = cnt;
			this.b = b;
		}
	}

	static int N;
	static int M;
	static boolean[][] map;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		map = new boolean[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(split[j]) == 1)
					map[i][j] = true;
			}
		}

		ans = Integer.MAX_VALUE;

		bfs();

		if (ans > N * M)
			ans = -1;
		System.out.println(ans);
	}

	static void bfs() {
		Queue<idx> queue = new LinkedList<idx>();
		queue.add(new idx(0, 0, 1, 0));

		while (!queue.isEmpty()) {

			idx now = queue.poll();
			int n = now.n;
			int m = now.m;
			int cnt = now.cnt;
			int breakOne = now.b;

			if (n == N - 1 && m == M - 1) {
				if (ans > cnt)
					ans = cnt;
				return;
			}

			if (visited[n][m][breakOne])
				continue;
			visited[n][m][breakOne] = true;

			for (int k = 0; k < 4; k++) {
				int x = n + dx[k];
				int y = m + dy[k];

				if (x < 0 || y < 0 || x >= N || y >= M)
					continue;
				if ((breakOne == 1 && map[x][y]) || visited[x][y][breakOne])
					continue;

				if (map[x][y] && breakOne == 0)
					queue.add(new idx(x, y, cnt + 1, 1));
				else
					queue.add(new idx(x, y, cnt + 1, breakOne));
			}
		}
	}
}
