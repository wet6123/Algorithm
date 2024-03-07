import java.util.Scanner;

//파리퇴치
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int j = 0; j < N; j++) {
				for(int k =0; k < N; k++) {					
					arr[j][k] = sc.nextInt();
				}
			}
			
			int sum;
			int max = 0;
			for(int j = 0; j < N-M+1; j++) {
				for(int k =0; k < N-M+1; k++) {	
					sum = 0;
					for (int l = 0; l < M; l++) {
						for (int p = 0; p < M; p++) {
							sum += arr[j + l][k + p];
						}
					}
					if(max < sum)max = sum;
				}
			}
			System.out.printf("#%d %d\n", i+1, max);
		}
	}
}
