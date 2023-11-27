import java.util.Scanner;

//동전 0
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		
		for(int n = N-1; n >= 0; n--) {
			arr[n] = sc.nextInt();
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int num = K / arr[i];
			ans += num;
			K -= num * arr[i];
		}
		
		System.out.println(ans);
	}
}
