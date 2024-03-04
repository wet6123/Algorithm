import java.util.Scanner;

//농작물 수확하기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			String[] arr = new String[N];
			
			for(int j = 0; j < N; j++) {
				arr[j] = sc.next();
			}
			
			int ans = 0;
			
			int k = 1;
			for(int j = 0; j < N/2; j++) {
					for(int l = 0; l < k; l++) {						
						ans += arr[j].charAt((N-k)/2+l)-48;
						ans += arr[N-1-j].charAt((N-k)/2+l)-48;
					}
				k += 2;
			}
			int idx = 0;
			while(idx < N) {
				ans += arr[N/2].charAt(idx)-48;
				idx++;
			}
			
			
			
			System.out.println("#" + (i+1) + " " +ans);
		}
	}
}
