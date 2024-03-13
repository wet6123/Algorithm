import java.util.Arrays;
import java.util.Scanner;

//숫자 배열 회전
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			int[][] arr90 = new int[N][N];
			int[][] ans = new int[N][3];
			for (int cnt = 0; cnt < 3; cnt++) {		
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						arr90[j][k] = arr[N - 1 - k][j];
						ans[j][cnt] = ans[j][cnt]*10 + arr90[j][k];
					}
				}
				for (int j = 0; j < N; j++) {					
					for (int k = 0; k < N; k++) {
						arr[j][k] = arr90[j][k];
					}
				}
			}
			System.out.println("#" + (i+1));
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 3; k++) {	
					if(N != (int)(Math.log10(ans[j][k])+1)){
						for(int l = 0; l < N - (int)(Math.log10(ans[j][k])+1);l++)System.out.print("0");
					}
					System.out.printf("%d ",ans[j][k]);
				}
				System.out.println();
			}
		}
	}
}
