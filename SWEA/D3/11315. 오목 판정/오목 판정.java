import java.util.Arrays;
import java.util.Scanner;

//오목 판정
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] arr = { { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } };
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			boolean ans = false;
			Find1: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'o') {
						for (int k = 0; k < 8; k++) {
							if (i + arr[k][0] * 4 < N && j + arr[k][1] * 4 < N && i + arr[k][0] * 4 >= 0 && j + arr[k][1] * 4 >= 0) {
								int cnt = 0;
								for (int l = 1; l < 5; l++) {
									if (map[i + arr[k][0] * l][j + arr[k][1] * l] == 'o')
										cnt++;
									else
										break;
								}
								if (cnt == 4) {
									ans = true;
									break Find1;
								}
							}
						}
					}
				}
			}
			if (ans)
				System.out.println("#" + (tc + 1) + " YES");
			else
				System.out.println("#" + (tc + 1) + " NO");
		}
	}
}
