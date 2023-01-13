import java.util.Scanner;

//안전 영역
public class Main {
	static int ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1};
	static int[] dy = { 1, -1, 0, 0};
	static int max;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int num = sc.nextInt();
				map[i][j] = num;
				if(num > max) max = num;
			}
		}
		ans = 1;
		
		rec(1);
		
		System.out.println(ans);
	}
	static void rec(int idx) {
		if(idx > max)
			return;
		
		visited = new boolean[N][N];
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] > idx) {
					visited[i][j] = true;
					cnt++;
					for(int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						
						if(x < 0 || y < 0 || x >= N || y >= N)
							continue;
							
						land(x, y, idx);
					}
				}
			}
		}
		if(ans < cnt) ans = cnt;
		rec(idx+1);
	}
	static void land(int i, int j, int idx) {
		if(!visited[i][j] && map[i][j] > idx) {
			visited[i][j] = true;
			for(int k = 0; k < 4; k++) {
				int x = i + dx[k];
				int y = j + dy[k];

				if(x < 0 || y < 0 || x >= N || y >= N)
					continue;
				
				land(x, y, idx);
			}
		}
	}
}
