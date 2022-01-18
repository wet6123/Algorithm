import java.util.Scanner;

public class 코드업1355 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			for (int k = 0; k < i; k++)
				System.out.print(" ");
			for (int j = num-i; j > 0; j--)
				System.out.print("*");
			System.out.println();
		}
	}
}
