import java.util.Scanner;

//타임머신

public class Main {
	static class Edge {
		int start, end, cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean flag = false;

		Edge[] map = new Edge[M + 1];

		for (int i = 1; i < M + 1; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();

			map[i] = new Edge(s, e, c);
		}

		long[] dist = new long[N + 1];
		for (int i = 2; i < N + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M + 1; j++) {
				Edge now = map[j];

				if (dist[now.start] == Integer.MAX_VALUE)
					continue;

				dist[now.end] = Math.min(dist[now.end], dist[now.start] + now.cost);
			}
		}

		for (int j = 1; j < M + 1; j++) {
			Edge now = map[j];

			if (dist[now.start] == Integer.MAX_VALUE)
				continue;

			if (dist[now.start] + now.cost < dist[now.end]) {
				flag = true;
			}
		}
		if (flag) {
			System.out.println(-1);
		}
		else {
			for (int i = 2; i <= N; i++) {
				if (dist[i] == Integer.MAX_VALUE) {
					System.out.println("-1");
				} else {
					System.out.println(dist[i]);
				}
			}
		}
	}
}
