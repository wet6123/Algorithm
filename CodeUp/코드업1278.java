import java.util.Scanner;

public class 코드업1278 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int cnt = 0;
		while(num != 0) {
			num = num/10;
			cnt++;
		}
		System.out.println(cnt);
	}
}
