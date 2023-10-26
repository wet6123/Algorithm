import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//다리 만들기 2
public class Main {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N;
	static int M;
	static int[][] map;
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int cnt = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					dfs(i, j, cnt);
					cnt++;
				}
			}
		}

		int E = fac(cnt - 2);
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][2] = 10;
		}

		int init;
		int end;
		int before;
		int len;
		int counter = 0;

		for (int i = 0; i < N; i++) {
			before = map[i][0];
			init = 0;
			end = 0;
			len = 0;
			for (int j = 0; j < M; j++) {
				int now = map[i][j];
				if (now == 0)
					len++;
				if (now != before) {
					if (before != 0 && now == 0) {
						init = before;
						len = 1;
					} else if (before == 0) {
						end = now;
						if (init > end) {
							int tmp = init;
							init = end;
							end = tmp;
						}
						if (len > 1 && init != 0 && end != 0) {
							int idx = counter;
							for (int k = 0; k < counter; k++) {
								if (edges[k][0] == init && edges[k][1] == end) {
									idx = k;
									break;
								}
							}
							if (len < edges[idx][2]) {
								edges[idx][0] = init;
								edges[idx][1] = end;
								edges[idx][2] = len;
								if (idx == counter)
									counter++;
							}
						}
					}
				}
				before = now;
			}
		}

		for (int j = 0; j < M; j++) {
			before = map[0][j];
			init = 0;
			end = 0;
			len = 0;
			for (int i = 0; i < N; i++) {
				int now = map[i][j];
				if (now == 0)
					len++;
				if (now != before) {
					if (before != 0 && now == 0) {
						init = before;
						len = 1;
					} else if (before == 0) {
						end = now;
						if (init > end) {
							int tmp = init;
							init = end;
							end = tmp;
						}
						if (len > 1 && init != 0 && end != 0) {
							int idx = counter;
							for (int k = 0; k < counter; k++) {
								if (edges[k][0] == init && edges[k][1] == end) {
									idx = k;
									break;
								}
							}
							if (len < edges[idx][2]) {
								edges[idx][0] = init;
								edges[idx][1] = end;
								edges[idx][2] = len;
								if (idx == counter)
									counter++;
							}
						}
					}
				}
				before = now;
			}
		}

		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		p = new int[cnt];

		for (int i = 2; i < cnt; i++) {
			p[i] = i;
		}

		int ans = 0;
		int pick = 0;
		
		for (int i = 0; i < counter; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}
			if (pick == ((cnt - 2) - 1))
				break;
		}
		
		if(pick < ((cnt - 2) - 1))
				ans = -1;

		System.out.println(ans);

	}

	static void makeSet(int x) {
		p[x] = x;
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	static void dfs(int x, int y, int idx) {
		map[x][y] = idx;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (map[nx][ny] == 1) {
				dfs(nx, ny, idx);
			}
		}
	}

	static int fac(int num) {
		if (num <= 1)
			return 1;
		else
			return fac(num - 1) * num;

	}
}
