import java.util.Scanner;

//어디에 단어가 들어갈 수 있을까
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = sc.nextInt();
				}
			}

			int ans = 0;
			int cntX, cntY;
			boolean flag;
			for (int j = 0; j < N; j++) {
				cntX = 0;
				cntY = 0;
				for (int k = 0; k < N; k++) {
					cntX += arr[j][k];
					if ((arr[j][k] == 0||k==N-1) && cntX == K) {
						ans++;
					}
					if(arr[j][k]==0)cntX=0;
					
					cntY += arr[k][j];
					if ((arr[k][j] == 0||k==N-1) && cntY == K) {
						ans++;
					}
					if(arr[k][j]==0)cntY=0;
				}
			}
			System.out.printf("#%d %d\n", i + 1, ans);
		}
	}
}
