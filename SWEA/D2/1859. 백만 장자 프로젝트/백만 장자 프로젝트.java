import java.util.Scanner;

//백만 장자 프로젝트
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			long sum = 0;
			for(int j = 0; j < N; j++)
				arr[j] = sc.nextInt();
			int max = 0;
			for(int j = N-1; j >= 0; j--) {
				if(arr[j] > max)max = arr[j];
				else sum += max-arr[j];
			}
			
			System.out.printf("#%d %d\n", i+1, sum);
		}
	}
}
