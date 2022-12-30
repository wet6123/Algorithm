import java.util.Scanner;

//N-Queen
public class Main {
	static int ans;
	static int N;
	static int[][] map;
	static int[] dx = {-1, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		ans = 0;

		queen(0);
		
		System.out.println(ans);
	}

	static void queen(int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (check(cnt, i)) {
				map[cnt][i] = 1;
				queen(cnt + 1);
				map[cnt][i] = 0;
			}
		}
	}
	
	static boolean check(int cnt, int num) {
		for(int i = 0; i < 3; i++) {
			int y = cnt;
			int x = num;
			
			while(true) {
				y -= 1;
				x += dx[i];
				
				if(y < 0 || x < 0 || y >= N || x >= N)
					break;
				if(map[y][x] == 1)
					return false;
			}
		}
		return true;
	}
}
