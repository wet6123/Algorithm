import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += (num/i)*i;
		}
			System.out.println(sum);
	}
}
