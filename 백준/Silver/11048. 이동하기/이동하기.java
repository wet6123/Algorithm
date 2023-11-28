import java.util.Arrays;
import java.util.Scanner;

//이동하기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[][] dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i - 1 >= 0 && j - 1 >= 0)
					dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + arr[i][j];
				else if (j - 1 >= 0)
					dp[i][j] = dp[i][j - 1] + arr[i][j];
				else if (i - 1 >= 0)
					dp[i][j] = dp[i - 1][j] + arr[i][j];
				else
					dp[i][j] = arr[i][j];
			}
		}
		System.out.println(dp[N - 1][M - 1]);
	}
}
