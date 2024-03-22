import java.util.Scanner;

//중간 평균값 구하기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int cnt = 10;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			int[] arr = new int[10];
			for (int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
				if (max < arr[j])
					max = arr[j];
				if (min > arr[j])
					min = arr[j];
				sum += arr[j];
			}
			for (int j = 0; j < 10; j++) {
				if (arr[j] == max) {
					sum -= max;
					cnt--;
				}
				else if (arr[j] == min) {
					sum -= min;
					cnt--;
				}
			}
			System.out.printf("#%d %d\n", i + 1, (sum+cnt/2)/cnt);
		}
	}
}
