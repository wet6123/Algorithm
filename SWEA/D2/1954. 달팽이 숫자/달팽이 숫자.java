import java.util.Scanner;

//달팽이 숫자
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int idx = 1;

			int m = -1;
			int n = -1;

			int cnt = N;
			for (int k = 0; k < cnt / 2; k++) {
				n++;
				m++;
				for (int j = 0; j < N - 1; j++) {
					arr[m][n++] = idx++;
				}

				for (int j = 0; j < N - 1; j++) {
					arr[m++][n] = idx++;
				}

				for (int j = 0; j < N - 1; j++) {
					arr[m][n--] = idx++;
				}

				for (int j = 0; j < N - 1; j++) {
					arr[m--][n] = idx++;
				}
				N -= 2;
			}
			if (cnt % 2 == 1)
				arr[cnt / 2][cnt / 2] = idx;

			System.out.println("#" + (i+1));
			for (int k = 0; k < cnt; k++) {
				for (int j = 0; j < cnt; j++) {
					System.out.print(arr[k][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
