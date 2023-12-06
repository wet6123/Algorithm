import java.util.Scanner;

//주유소
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		long[] road = new long[T - 1];
		long[] price = new long[T];

		for (int tc = 0; tc < T - 1; tc++) {
			road[tc] = sc.nextInt();
		}
		for (int tc = 0; tc < T; tc++) {
			price[tc] = sc.nextInt();
		}

		long total = 0;

		long now = price[0];
		int idx = 0;
		while (idx < T - 1) {
			if (now > price[idx]) {
				now = price[idx];
			}
			total += now * road[idx];

			idx++;
		}
		System.out.println(total);
	}
}
