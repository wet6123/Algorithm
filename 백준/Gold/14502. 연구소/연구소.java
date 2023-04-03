import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int dx[] = { 0, 0, 1, -1 };
	static final int dy[] = { 1, -1, 0, 0 };
	static int N;
	static int M;
	static int max;
	static int[][] map;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;

		wall(0);

		bw.write(max + "");
		bw.close();
	}

	static void wall(int wallCnt) {
		if (wallCnt == 3) {
			virus();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					wall(wallCnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void virus() {
		Queue<Node> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					q.add(new Node(i, j));
				}
			}
		}

		int copyMap[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}

		while (!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (copyMap[nx][ny] == 0) {
						q.add(new Node(nx, ny));
						copyMap[nx][ny] = 2;
					}
				}

			}
		}
		safeCheck(copyMap);
	}

	private static void safeCheck(int[][] map) {
		int safeZone = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					safeZone++;
				}
			}
		}
		if (max < safeZone) {
			max = safeZone;
		}
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
