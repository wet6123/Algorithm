import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//도시 분할 계획
public class Main {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] edges = new int[M][3];
		for (int j = 0; j < M; j++) {
			edges[j][0] = sc.nextInt();
			edges[j][1] = sc.nextInt();
			edges[j][2] = sc.nextInt();
		}

		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}

		});

		p = new int[N + 1];

		for (int i = 0; i < N; i++) {
			makeSet(i);
		}

		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < M; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				cnt++;
			}
			if (cnt == N - 2)
				break;
		}
		System.out.println(ans);
	}

	static void makeSet(int i) {
		p[i] = i;
	}

	static int findSet(int i) {
		if (p[i] != i)
			p[i] = findSet(p[i]);
		return p[i];
	}

	static void union(int i, int j) {
		p[findSet(j)] = findSet(i);
	}
}
