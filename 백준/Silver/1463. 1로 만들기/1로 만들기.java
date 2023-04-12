import java.util.Scanner;

public class Main {
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		search(N, 0);

		System.out.println(min);
	}

	public static void search(int num, int cnt) {
		if (num == 1) {
			if (cnt < min)
				min = cnt;
			return;
		} else {
			if (cnt >= min) {
				return;
			} else {
				if (num % 3 == 0) {
					search(num / 3, cnt + 1);
				}
				if (num % 2 == 0) {
					search(num / 2, cnt + 1);
				}
				search(num - 1, cnt + 1);
			}
		}
	}
}