import java.util.Scanner;

//[S/W 문제해결 기본] 2일차 - Sum
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
		int T = sc.nextInt();
			int[][] arr = new int[100][100];
			int max = Integer.MIN_VALUE;
			int sum;
			int diag1 = 0;
			int diag2 = 0;
			for (int j = 0; j < 100; j++) {
				sum = 0;
				for (int k = 0; k < 100; k++) {
					arr[j][k] = sc.nextInt();
					sum += arr[j][k];
				}
				if (sum > max)
					max = sum;
			}
			for (int k = 0; k < 100; k++) {
				diag1 += arr[k][k];
				diag2 += arr[99 - k][99 - k];
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][k];
				}
				if (sum > max)
					max = sum;
			}
			if (diag1 > max)
				max = diag1;
			if (diag2 > max)
				max = diag2;
			System.out.printf("#%d %d\n",T,max);
		}
	}
}
