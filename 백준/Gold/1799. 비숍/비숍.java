import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, black, white;
	static int[][] map;
	static boolean[][] visit, color;
	static int[] dx = { -1, -1 };
	static int[] dy = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visit = new boolean[N][N];
		color = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if ((i + j) % 2 == 0) {
					color[i][j] = true;
				}
			}
		}

		black = 0;
		white = 0;

		nBishop(0, 0, true);
		nBishop(0, 0, false);

		bw.write((black + white) + "");
		bw.close();
	}

	public static void nBishop(int col, int depth, boolean check) {
		for (int idx = col; idx < N * N; idx++) {
			int i = idx / N;
			int j = idx % N;

			if (color[i][j] == check && map[i][j] == 1 && isOk(i, j)) {
				visit[i][j] = true;
				nBishop(idx + 1, depth + 1, check);
				visit[i][j] = false;
			}
		}

		if (check) {
			black = Math.max(black, depth);
		} else {
			white = Math.max(white, depth);
		}
	}

	public static boolean isOk(int x, int y) {
		for (int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			while (true) {
				if (isOut(nx, ny)) {
					break;
				}
				if (visit[nx][ny]) {
					return false;
				}
				nx += dx[i];
				ny += dy[i];
			}
		}
		return true;
	}

	public static boolean isOut(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return true;
		}
		return false;
	}
}
