import java.util.Arrays;
import java.util.Scanner;

//동철이의 프로그래밍 대회
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					arr[n] += sc.nextInt();
				}				
			}
			Arrays.sort(arr);
			
			int max = arr[N-1];
			int ans = 0;
			for(int n = N-1; n >= 0; n--) {
				if(arr[n] < max)
					break;
				ans++;
			}
			System.out.println("#" + (tc + 1) + " " + ans + " " + max);
		}
	}
}
