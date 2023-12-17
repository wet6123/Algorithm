import java.util.Scanner;

// 2xn 타일링_Bottom-up
public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int div = 10007;
		
		int N = sc.nextInt();
		int[] memo = new int[N+2];
		
		memo[1] = 1;
		memo[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			memo[i] =(memo[i - 2] + memo[i - 1]) % div;
		}
		System.out.println(memo[N]);
	}
}
