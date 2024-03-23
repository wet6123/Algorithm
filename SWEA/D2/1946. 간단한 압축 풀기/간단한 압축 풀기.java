import java.util.Scanner;

//간단한 압축 풀기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {			
			int N = sc.nextInt();
			System.out.println("#"+(i+1));
			int cnt = 1;
			for(int j = 0; j < N; j++) {
				String alpha = sc.next();
				int num = sc.nextInt();
				for(int k = 0; k < num; k++) {
					System.out.print(alpha);
					if(cnt==10) {
						System.out.println();
						cnt = 0;
					}
					cnt++;
				}
			}
			System.out.println();
		}
	}
}
