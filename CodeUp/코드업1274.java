import java.util.Scanner;

public class 코드업1274 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String isPrime = "prime";
		for(int i = 2; i < num; i++) {
			if(num%i == 0) {
				isPrime = "not prime";
			}
		}
		System.out.println(isPrime);
	}
}
