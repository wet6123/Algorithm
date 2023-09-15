import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//미로 탐색
public class Main {
	static class idx {
		int n, m;

		public idx(int n, int m) {
			this.n = n;
			this.m = m;
		}
	}

	static int N;
	static int M;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		map = new boolean[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(split[j]) == 0)
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
		queue.add(new idx(0, 0));
		int cnt = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int time = 0; time < size; time++) {
				idx now = queue.poll();
				int n = now.n;
				int m = now.m;

				if (n == N - 1 && m == M - 1) {
					if (ans > cnt)
						ans = cnt;
					return;
				}

				if (visited[n][m])
					continue;
				visited[n][m] = true;

				for (int k = 0; k < 4; k++) {
					int x = n + dx[k];
					int y = m + dy[k];

					if (x < 0 || y < 0 || x >= N || y >= M)
						continue;
					if (map[x][y] || visited[x][y])
						continue;

					queue.add(new idx(x, y));
				}
			}
			cnt++;
		}
	}
}
