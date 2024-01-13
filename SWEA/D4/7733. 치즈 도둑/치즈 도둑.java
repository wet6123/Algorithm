import java.util.Scanner;

//치즈 도둑
public class Solution {
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int max = 0;
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = sc.nextInt();
					map[i][j] = num;
					if (max < num)
						max = num;
				}
			}
			
			int ans = 0;
			int cnt = 0;

			for (int k = 0; k < max; k++) {
				visited = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j] <= k) {
							visited[i][j] = true;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(!visited[i][j]) {
							cnt++;
							dfs(i, j);
						}
					}
				}
				if(ans < cnt)ans = cnt;
				cnt = 0;
			}
			System.out.println("#" + (tc + 1) + " " + ans);
		}
	}
	static void dfs(int i, int j) {
		visited[i][j] = true;
		for(int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			
			if(!visited[ny][nx])
				dfs(ny, nx);
		}
	}
}
