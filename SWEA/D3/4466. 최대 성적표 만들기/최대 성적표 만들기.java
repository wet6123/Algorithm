import java.util.Arrays;
import java.util.Scanner;

//최대 성적표 만들기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			int ans = 0;
			for (int i = N - 1; i >= N - K; i--) {
				ans += arr[i];
			}
			System.out.println("#" + (tc + 1) + " " + ans);
		}
	}
}
