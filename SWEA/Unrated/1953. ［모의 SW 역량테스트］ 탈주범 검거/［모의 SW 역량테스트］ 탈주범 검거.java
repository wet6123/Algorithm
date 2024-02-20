import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//탈주범 검거
public class Solution {
	static int ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static Queue<Pos> queue;
	static int N;
	static int M;
	
	static class Pos {
		int r, c, type;

		public Pos(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt();
			
			visited = new boolean[N][M];
			map = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}				
			}
			ans = 0;
			bfs(R, C, L);
			
			System.out.println("#" + (tc+1) + " " + ans);
		}
	}
	static void bfs(int x, int y, int cnt) {
		queue = new LinkedList<Pos>();
		queue.add(new Pos(x, y, map[x][y]));
		int counter = 0;
		
		while(!queue.isEmpty()) {
			if(cnt == counter)
				break;
			counter++;
			int size = queue.size();
			for(int s = 0; s < size; s++) {
				Pos now = queue.poll();
				if(!visited[now.r][now.c] && now.type != 0) {
					visited[now.r][now.c] = true;
					ans++;
					move(now.r, now.c, now.type);
				}
			}
		}
	}
	static void move(int x, int y, int num) {
		Queue<Integer> tmp = new LinkedList<>();
		switch (num) {
		case 1:
			tmp.add(0);
			tmp.add(1);
			tmp.add(2);
			tmp.add(3);
			break;

		case 2:
			tmp.add(2);
			tmp.add(3);
			break;
			
		case 3:
			tmp.add(0);
			tmp.add(1);
			break;
			
		case 4:
			tmp.add(0);
			tmp.add(2);
			break;
			
		case 5:
			tmp.add(0);
			tmp.add(3);
			break;
			
		case 6:
			tmp.add(1);
			tmp.add(3);
			break;
			
		case 7:
			tmp.add(1);
			tmp.add(2);
			break;
		}
		
		int size = tmp.size();
		
		for(int i = 0; i < size; i++) {
			int type = tmp.poll();
			int nx = x + dx[type];
			int ny = y + dy[type];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			
			if(check(x, y, nx, ny, map[nx][ny]))
				continue;
			
			Pos next = new Pos(nx, ny, map[nx][ny]);
			queue.add(next);
		}
	}
	static boolean check(int x, int y, int nx, int ny, int nextType) {
		int dx = nx-x;
		int dy = ny-y;
		if(dx < 0 && dy == 0) {
			if(nextType == 3 || nextType == 4 || nextType == 7)
				return true;
		} else if(dx > 0 && dy == 0) {
			if(nextType == 3 || nextType == 5 || nextType == 6)
				return true;
		} else if(dx == 0 && dy > 0) {
			if(nextType == 2 || nextType == 4 || nextType == 5)
				return true;
		} else if(dx == 0 && dy < 0) {
			if(nextType == 2 || nextType == 6 || nextType == 7)
				return true;
		}
		return false;
	}
}
