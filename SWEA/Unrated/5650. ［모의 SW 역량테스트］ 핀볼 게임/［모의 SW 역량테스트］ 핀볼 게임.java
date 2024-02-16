import java.util.Scanner;

//핀볼 게임
public class Solution {
	static int N;
	static int sum;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int ans = 0;
			int[] dx = { 0, 0, 1, -1 };
			int[] dy = { 1, -1, 0, 0 };// 우좌하상

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 11;// 11: 시작점
						for (int n = 0; n < 4; n++) {
							sum = 0;
							move(i, j, dx[n], dy[n]);
							ans = Math.max(sum, ans);
						}
						map[i][j] = 0;
					}
				}
			}

			System.out.println("#" + (tc + 1) + " " + ans);
		}
	}

	static void move(int i, int j, int x, int y) {
		all: while (true) {
			int idx = 1;
			int ni = i + x * idx;
			int nj = j + y * idx;

			if (ni < 0 || nj < 0 || ni >= N || nj >= N) {
				sum++;
				i = ni;
				j = nj;
				x = -x;
				y = -y;
				continue;
			}

			while (map[ni][nj] == 0) {
				idx++;
				ni = i + x * idx;
				nj = j + y * idx;

				if (ni < 0 || nj < 0 || ni >= N || nj >= N) {
					sum++;
					i = ni;
					j = nj;
					x = -x;
					y = -y;
					continue all;
				}
			}

			int type = map[ni][nj];
			i = ni;
			j = nj;

			if (type == 11 || type == -1) {
				break all;
			} else if (type == 1) {
				sum++;
				if ((x == 0 && y == 1) || (x == -1 && y == 0)) {
					x = -x;
					y = -y;
				}
				else if (x == 0 && y == -1) {
					x = -1;
					y = 0;
				}
				else if (x == 1 && y == 0) {
					x = 0;
					y = 1;
				}
			} else if (type == 2) {
				sum++;
				if ((x == 0 && y == 1) || (x == 1 && y == 0)) {
					x = -x;
					y = -y;
				}
				else if (x == 0 && y == -1) {
					x = 1;
					y = 0;
				}
				else if (x == -1 && y == 0) {
					x = 0;
					y = 1;
				}
			} else if (type == 3) {
				sum++;
				if ((x == 0 && y == -1) || (x == 1 && y == 0)) {
					x = -x;
					y = -y;
				}
				else if (x == 0 && y == 1) {
					x = 1;
					y = 0;
				}
				else if (x == -1 && y == 0) {
					x = 0;
					y = -1;
				}
			} else if (type == 4) {
				sum++;
				if ((x == 0 && y == -1) || (x == -1 && y == 0)) {
					x = -x;
					y = -y;
				}
				else if (x == 0 && y == 1) {
					x = -1;
					y = 0;
				}
				else if (x == 1 && y == 0) {
					x = 0;
					y = -1;
				}
			} else if (type == 5) {
				sum++;
				if ((x == 0 && y == 1) || (x == 0 && y == -1) || (x == 1 && y == 0) || (x == -1 && y == 0)) {
					x = -x;
					y = -y;
				}
			} else if (type >= 6 && type <= 10) {
				for (int q = 0; q < N; q++) {
					for (int w = 0; w < N; w++) {
						if (map[q][w] == type && (ni != q || nj != w)) {
							i = q;
							j = w;
						}
					}
				}
			}
		}
	}
}