import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//뱀과 사다리 게임
public class Main {
	static int ans;
	static Queue<Integer> queue;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		map = new int[10][10];
		queue = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();

			int y = (st - 1) / 10;
			int x = (st - 1) % 10;

			map[y][x] = ed;
		}
		for (int m = 0; m < M; m++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();

			int y = (st - 1) / 10;
			int x = (st - 1) % 10;

			map[y][x] = ed;
		}
		int now = 1;
		ans = 1;

		bfs(now);

		System.out.println(ans);
	}

	static void bfs(int now) {
		for (int i = 1; i < 7; i++) {
			int idx = now + i;
			if (idx == 100)
				return;
			else if (idx > 100)
				continue;

			int y = (idx - 1) / 10;
			int x = (idx - 1) % 10;

			if (map[y][x] != 0)
				idx = map[y][x];
			queue.add(idx);
		}
		while (queue.size() > 0) {
			int size = queue.size();
			ans++;
			int nextIdx = 0;
			for (int i = 0; i < size; i++) {
				int next = queue.poll();
				if (next == 100)
					return;
				else if (next > 100)
					continue;

				for (int j = 1; j < 7; j++) {
					int idx = next + j;
					if (idx == 100)
						return;
					else if (idx > 100)
						continue;

					int y = (idx - 1) / 10;
					int x = (idx - 1) % 10;

					if(map[y][x] != 0) {
						while (map[y][x] != 0) {
							idx = map[y][x];
							y = (idx - 1) / 10;
							x = (idx - 1) % 10;
						}
						queue.add(idx);
					}
					else if(map[y][x] == 0) {
						nextIdx = idx;
					}
				}
				if(nextIdx != 0)
					queue.add(nextIdx);
			}
		}
	}
}
