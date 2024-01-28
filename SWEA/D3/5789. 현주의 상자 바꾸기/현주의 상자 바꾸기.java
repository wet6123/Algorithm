import java.util.Scanner;

//현주의 상자 바꾸기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			
			int[] arr = new int[N];
			for(int q = 0; q < Q; q++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				
				for(int i = st-1; i < ed; i++) {
					arr[i] = q+1;
				}
			}
			
			System.out.print("#" + (tc+1));
			for(int n = 0; n < N; n++)
				System.out.print(" " + arr[n]);
            System.out.println();
		}
	}
}
