import java.util.Scanner;

public class 코드업1380 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 1; i < num; i++) {
			if (6>= i && i >= 1 && (num-i) >= 1 && (num-i) <= 6 )
				System.out.printf("%d %d\n", i, num - i);
		}
	}
}
