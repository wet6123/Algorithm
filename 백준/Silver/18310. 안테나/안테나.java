import java.util.Arrays;
import java.util.Scanner;

//안테나
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[T];

		for (int tc = 0; tc < T; tc++) {
			arr[tc] = sc.nextInt();
		}
		Arrays.sort(arr);

		int ans = 0;
		long min = Integer.MAX_VALUE;
		if(T>1) {			
			for (int i = (T+1)/2 -1; i <= (T+1)/2; i++) {
				long sum = 0;
				for (int j = 0; j < T; j++) {
					sum += Math.abs(arr[i] - arr[j]);
				}
				if (min > sum) {
					min = sum;
					ans = arr[i];
				}
			}
		} else ans = arr[0];

		System.out.println(ans);
	}
}
