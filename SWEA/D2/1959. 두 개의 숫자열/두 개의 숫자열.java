import java.util.Scanner;

//두 개의 숫자열
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int sum;
			int max = Integer.MIN_VALUE;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arrN = new int[N];
			int[] arrM = new int[M];
			for (int j = 0; j < N; j++) {
				arrN[j] = sc.nextInt();
			}
			for (int k = 0; k < M; k++) {
				arrM[k] = sc.nextInt();
			}
			for (int j = 0; j <= Math.abs(N - M); j++) {
				sum = 0;
				if (N < M) {
					for (int k = 0; k < N; k++) {
						sum += arrN[k]*arrM[k+j];
					}
				} else {
					for (int k = 0; k < M; k++) {
						sum += arrN[k+j]*arrM[k];
					}
				}
				if(max < sum)max = sum;
			}
			System.out.printf("#%d %d\n",i+1,max);
		}
	}
}
