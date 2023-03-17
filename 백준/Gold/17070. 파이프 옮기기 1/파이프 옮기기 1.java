import java.util.Scanner;

//파이프 옮기기 1
public class Main {
	static int ans;
	static int min;
	static int N;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}			
		}
		
		ans = 0;
		
		dfs(1, 0, 0);
		
		System.out.println(ans);
	}
	static void dfs(int x, int y, int dir) {// dir 0:가로  1:세로 2:대각선
		if(x >= N || y >= N) {
			return;
		}
		
		if(x == N-1 && y == N-1) {
			ans += 1;
			return;
		}
		
		if(dir == 0) { //가로
			move(x, y, 0);//가로로 가기

			move(x, y, 2);//대각선으로 가기
		}else if(dir == 1) { //세로
			move(x, y, 1);//세로로 가기
			
			move(x, y, 2);//대각선으로 가기
			
		}else if(dir == 2) { //대각선
			move(x, y, 0);//가로로 가기
			
			move(x, y, 1);//세로로 가기
			
			move(x, y, 2);//대각선으로 가기
		}
	}
	static void move(int x, int y, int dir) {
		if(dir == 0) { //가로
			if(x+1 >= N || map[y][x+1] == 1)
				return;
			
			map[y][x+1] = 1;
			dfs(x+1, y, 0);//가로로 가기
			map[y][x+1] = 0;
			
		}else if(dir == 1) { //세로
			if(y+1 >= N || map[y+1][x] == 1)
				return;
			
			map[y+1][x] = 1;
			dfs(x, y+1, 1);//세로로 가기
			map[y+1][x] = 0;
			
		}else if(dir == 2) { //대각선
			if(x+1 >= N || y+1 >= N || map[y][x+1] == 1 || map[y+1][x] == 1 || map[y+1][x+1] == 1)
				return;
			
			map[y][x+1] = 1;
			map[y+1][x] = 1;
			map[y+1][x+1] = 1;
			dfs(x+1, y+1, 2);//대각선으로 가기
			map[y][x+1] = 0;
			map[y+1][x] = 0;
			map[y+1][x+1] = 0;
		}
		
	}
}
