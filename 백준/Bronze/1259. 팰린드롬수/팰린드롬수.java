import java.util.Scanner;

//팰린드롬수
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String N = sc.next();
			if (N.length() == 1 && N.charAt(0) == '0')
				break;

			boolean ans = true;
			int size = N.length();
			for (int i = 0; i < size / 2; i++) {
				if (N.charAt(i) != N.charAt(size - i - 1)) {
					ans = false;
				}
			}
			if (ans) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}
}
