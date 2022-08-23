import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int minSix = sc.nextInt();
		int minOne = sc.nextInt();
		int sixPrice = 0;
		int onePrice = 0;

		for (int i = 1; i < M; i++) {
			sixPrice = sc.nextInt();
			onePrice = sc.nextInt();
			if (sixPrice < minSix)
				minSix = sixPrice;
			if (onePrice < minOne)
				minOne = onePrice;
		}

		int ans = 0;

		if (minSix > minOne * 6) {
			ans = minOne * N;
		} else {
			ans = minSix * (N / 6);
			if (minSix > minOne * (N % 6)) {
				ans += minOne * (N % 6);
			} else {
				ans += minSix;
			}
		}
		System.out.println(ans);
	}
}