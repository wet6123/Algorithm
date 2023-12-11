import java.util.Scanner;

//1, 2, 3 더하기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			// inc(a) = inc(a-1) + inc(a-2) + inc(a-3) if, a > 4
			int N = sc.nextInt();

			int[] inc;
			if (N > 2) {
				inc = new int[N];
			} else {
				inc = new int[3];
			}
			inc[0] = 1;
			inc[1] = 2;
			inc[2] = 3;

			int[] num;
			if (N > 2) {
				num = new int[N];
			} else {
				num = new int[3];
			}
			num[0] = 1;
			num[1] = 2;
			num[2] = 4;

			for (int n = 3; n < N; n++) {
				inc[n] = inc[n - 1] + inc[n - 2] + inc[n - 3];
				num[n] = num[n - 1] + inc[n - 1];
			}

			if (N >= 3)
				System.out.println(num[N - 1]);
			if (N < 3)
				System.out.println(num[N - 1]);
		}
	}
}
