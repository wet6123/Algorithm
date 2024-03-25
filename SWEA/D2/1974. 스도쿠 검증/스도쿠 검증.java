import java.util.Scanner;

//스도쿠 검증
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int[][] arr = new int[9][9];

			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			int flag = 1;
			int sum1;
			int sum2;
			for (int j = 0; j < 9; j++) {
				sum1 = 0;
				sum2 = 0;
				for (int k = 0; k < 9; k++) {
					sum1 += arr[j][k];
					sum2 += arr[k][j];
				}
				if (sum2 != 45 || sum1 != 45) {
					flag = 0;
					break;
				}
			}

			for (int j = 0; j < 9; j += 3) {
				for (int k = 0; k < 9; k += 3) {
					sum1 = 0;
					for (int l = 0; l < 3; l++) {
						for (int m = 0; m < 3; m++) {
							sum1 += arr[j + l][k + m];
						}
					}
					if (sum1 != 45) {
						flag = 0;
						break;
					}
				}
			}
			
			System.out.printf("#%d %d\n", i+1, flag);
		}
	}
}
