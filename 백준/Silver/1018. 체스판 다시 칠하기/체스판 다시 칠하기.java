import java.util.Scanner;

//체스판 다시 칠하기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int dx = 0; dx <= N - 8; dx++) {
			for (int dy = 0; dy <= M - 8; dy++) {
				int cnt1 = 0;
				int cnt2 = 0;
				
				for (int i = dx; i < 8 + dx; i++) {
					for (int j = dy; j < 8 + dy; j++) {
						char tmp = map[i][j];
						if (i % 2 == 0) {
							if (j % 2 == 0) {
								if (tmp == 'W')
									cnt1++;
								else
									cnt2++;
							} else if (j % 2 == 1) {
								if (tmp == 'B')
									cnt1++;
								else
									cnt2++;
							}
						}
						if (i % 2 == 1) {
							if (j % 2 == 0) {
								if (tmp == 'B')
									cnt1++;
								else
									cnt2++;
							} else if (j % 2 == 1) {
								if (tmp == 'W')
									cnt1++;
								else
									cnt2++;
							}
						}
					}
				}
				ans = Math.min(Math.min(ans, cnt1), cnt2);
			}
		}
		System.out.println(ans);
	}
}
