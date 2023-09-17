import java.util.Arrays;
import java.util.Scanner;

//스위치 켜고 끄기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int gender = sc.nextInt();
			int idx = sc.nextInt();

			// boy
			if (gender == 1) {
				int cnt = idx;
				while (idx <= N) {
					if (arr[idx - 1] == 1)
						arr[idx - 1] = 0;
					else
						arr[idx - 1] = 1;
					idx += cnt;
				}
			}
			// girl
			else if (gender == 2) {
				if (arr[idx - 1] == 1)
					arr[idx - 1] = 0;
				else
					arr[idx - 1] = 1;
				
				int cnt = 1;

				while ((idx + cnt) <= N && (idx - cnt) > 0) {
					if (arr[idx - 1 + cnt] == arr[idx - 1 - cnt]) {
						if (arr[idx - 1 + cnt] == 1) {
							arr[idx - 1 + cnt] = 0;
							arr[idx - 1 - cnt] = 0;
						} else {
							arr[idx - 1 + cnt] = 1;
							arr[idx - 1 - cnt] = 1;
						}
					} else {
						break;
					}
					cnt++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
			if(i!=0 && (i+1)%20 == 0) {
				System.out.println();
			}
		}
		
	}
}