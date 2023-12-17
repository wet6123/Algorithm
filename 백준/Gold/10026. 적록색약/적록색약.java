import java.util.Scanner;

//적록색약
public class Main {
	static int N;
	static boolean[][] visitedN;
	static boolean[][] visitedB;
	static int[] diffx = { 0, 0, 1, -1 };
	static int[] diffy = { 1, -1, 0, 0 };
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		visitedN = new boolean[N][N];
		visitedB = new boolean[N][N];
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
		}

		int normal = 0;
		int blind = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visitedN[i][j]) {
					searchN(i, j, map[i][j]);
					normal++;
				}

				if (!visitedB[i][j]) {
					searchB(i, j, map[i][j]);
					blind++;
				}
			}
		}
		System.out.println(normal + " " + blind);
	}

	static void searchN(int x, int y, char idx) {
		for(int i = 0; i < 4; i++) {
			int dx = x + diffx[i];
			int dy = y + diffy[i];
			
			if(dx < 0 || dx >= N || dy < 0 || dy >= N )
				continue;
			if(visitedN[dx][dy])
				continue;
			
			if(map[dx][dy] == idx) {
				visitedN[dx][dy] = true;
				searchN(dx, dy, idx);
			}
		}
	}

	static void searchB(int x, int y, char idx) {
		for(int i = 0; i < 4; i++) {
			int dx = x + diffx[i];
			int dy = y + diffy[i];
			
			if(dx < 0 || dx >= N || dy < 0 || dy >= N)
				continue;
			if(visitedB[dx][dy])
				continue;
			
			if(idx == 'B') {				
				if(map[dx][dy] == idx) {
					visitedB[dx][dy] = true;
					searchB(dx, dy, idx);
				}
			}else {
				if(map[dx][dy] != 'B') {
					visitedB[dx][dy] = true;
					searchB(dx, dy, idx);
				}
			}
		}
	}
}
