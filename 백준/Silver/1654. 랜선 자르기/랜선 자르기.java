import java.util.Scanner;

//랜선 자르기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[K];
		long max = 0;

		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(arr[i], max);
		}

		max++;
		long min = 0;
		long mid = 0;
		long cnt = 0;

		while (min < max) {
			mid = (max + min) / 2;
			cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += (arr[i] / mid);
			}

			if (cnt < N)
				max = mid;
			else
				min = mid + 1;
		}
		System.out.println(min - 1);
	}
}
