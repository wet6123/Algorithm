import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

//통계학
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		int sum = 0;
		int max = Integer.MAX_VALUE * (-1);
		int min = Integer.MAX_VALUE;

		for (int n = 0; n < N; n++) {
			int num = sc.nextInt();
			arr[n] = num;
			sum += num;
			if (max < num)
				max = num;
			if (min > num)
				min = num;
		}
		Arrays.sort(arr);
		int range = max - min;
		int[] cnt = new int[range + 1];

		int maxCnt = 0;
		for (int n = 0; n < N; n++) {
			int idx = arr[n] - min;
			cnt[idx]++;
			maxCnt = Math.max(maxCnt, cnt[idx]);
		}
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = range; i >= 0; i--) {
			if (maxCnt == cnt[i]) {
				list.add(i + min);
			}
		}

		if (list.size() > 1) {
			Collections.sort(list);
			list.remove();
		}

		int avg;
		if(sum > 0)
			avg = (sum + (N / 2)) / N;
		else
			avg = (sum - (N / 2)) / N;
		int med = arr[N / 2];
		int mode = list.remove();

		System.out.println(avg);
		System.out.println(med);
		System.out.println(mode);
		System.out.println(range);
	}
}
