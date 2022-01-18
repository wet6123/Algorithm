import java.util.Scanner;

public class 코드업1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		num = num / 2;
		int ans = (num+1)*num;
		System.out.println(ans);
	}
}
