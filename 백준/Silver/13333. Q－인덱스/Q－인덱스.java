import java.util.Arrays;
import java.util.Scanner;

//Q-인덱스
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] arr = new int[T];
		for (int tc = 0; tc < T; tc++) {
			arr[tc] = sc.nextInt();
		}
		Arrays.sort(arr);
		int idx = 0;
		for (int i = 0; i <= T; i++) {
			int upCnt = 0;
			int undCnt = 0;
			for (int j = 0; j < T; j++) {
				if (i <= arr[j] && i > upCnt)
					upCnt++;
				else if (i >= arr[j])
					undCnt++;
			}
			if (upCnt >= i && undCnt <= T-i)
				idx = i;
		}
		System.out.println(idx);
	}
}
