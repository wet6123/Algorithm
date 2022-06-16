import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//게임 개발

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] time = new int[N + 1];
		LinkedList[] list = new LinkedList[N + 1];

		int[] cnt = new int[N + 1];

		for (int n = 1; n < N + 1; n++) {
			list[n] = new LinkedList<>();
		}

		for (int n = 1; n < N + 1; n++) {
			time[n] = sc.nextInt();

			int tmp = sc.nextInt();
			while (tmp != -1) {
				cnt[n]++;
				list[tmp].add(n);
				tmp = sc.nextInt();
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (cnt[i] == 0) {
				q.offer(i);
			}
		}

		int[] result = new int[N + 1];

		while (!q.isEmpty()) {
			int now = q.poll();

			int size = list[now].size();

			for (int j = 0; j < size; j++) {
				int next = (int) list[now].get(j);
				cnt[next]--;

				result[next] = Math.max(result[next], result[now] + time[now]);

				if (cnt[next] == 0) {
					q.offer(next);
				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.println(result[i] + time[i]);
		}
	}
}
