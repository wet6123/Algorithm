import java.util.Arrays;
import java.util.Scanner;

//숫자를 정렬하자
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			
			int idx;
			for(int j = 0; j < N; j++) {
				idx = j;
				for(int k = j; k < N; k++) {
					if(arr[k] < arr[idx])
						idx = k;
				}
				int tmp = arr[idx];
				arr[idx] = arr[j];
				arr[j] = tmp;
			}
			System.out.print("#" + (i+1));
			for(int j = 0; j < N; j++)
				System.out.print(" " + arr[j]);
			System.out.println();
		}
	}
}
