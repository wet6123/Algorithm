import java.util.Scanner;

//[S/W 문제해결 기본] 5일차 - Magnetic
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();

			int[][] map = new int[T][T];

			for (int i = 0; i < T; i++) {
				for (int j = 0; j < T; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			for (int j = 0; j < T; j++) {
				for (int i = 0; i < T; i++) {
					if(map[i][j] == 1) {
						for (int k = i+1; k < T; k++) {
							if(map[k][j] == 2) {
								cnt++;
								i=k;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + (tc+1) + " " + cnt);
		}
	}
}
