import java.util.Arrays;
import java.util.Scanner;

// 줄자접기
public class Main {

	static double start;
	static double end;
	static double[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		start = 0;
		end = sc.nextInt();

		arr = new double[6];
		for (int i = 0; i < 6; i++)
			arr[i] = sc.nextInt();
		
		rec(0);

		System.out.println(end - start);
	}

	public static void rec(int N) {
		if (N > 5)
			return;

		if (arr[N] != arr[N+1]) {
			double mid = (arr[N] + arr[N + 1]) / 2;

			if (mid - end < start - mid) {
				start = mid;
			} else {
				end = mid;
			}

			for (int i = N + 2; i < 6; i++) {
				if (start > arr[i]) {
					arr[i] += (start - arr[i]) * 2;
				}

				if (end < arr[i]) {
					arr[i] -= (arr[i] - end) * 2;
				}
			}
		}

		rec(N + 2);
	}
}
