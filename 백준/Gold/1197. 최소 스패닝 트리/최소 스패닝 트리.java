import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//최소 스피닝 트리
public class Main {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


			int V = sc.nextInt();
			int E = sc.nextInt();

			int[][] edges = new int[E][3];

			for (int i = 0; i < E; i++) {
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
				edges[i][2] = sc.nextInt();
			}

			Arrays.sort(edges, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			int ans = 0;
			int cnt = 0;
			p = new int[V + 1];

			for (int i = 1; i < V + 1; i++) {
				makeset(i);
			}

			for (int i = 0; i < E; i++) {
				if (cnt >= V - 1)
					break;
				int px = findset(edges[i][0]);
				int py = findset(edges[i][1]);

				if (px != py){
					union(px, py);
				    cnt++;
				    ans += edges[i][2];
                }
			}
			System.out.println(ans);
	}

	static void makeset(int idx) {
		p[idx] = idx;
	}

	static int findset(int idx) {
		if (idx != p[idx])
			p[idx] = findset(p[idx]);
		return p[idx];
	}

	static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}
}
