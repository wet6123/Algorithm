import java.util.Scanner;

//ATM
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
		}
		
		int sum = 0;

		for (int i = N; i > 0; i--) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int j = 0; j < N; j++) {
				if (arr[j] > 0 && arr[j] < min) {
					min = arr[j];
					idx = j;
				}
			}
			sum += arr[idx] * i;
			arr[idx] = 0;
		}
		System.out.println(sum);
	}
}
