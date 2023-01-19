import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//촌수 계산
public class Main {
	static boolean[] visited;
	static LinkedList<Integer>[] tree;
	static Queue<Integer> queue;
	static int A;
	static int B;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();

		int T = sc.nextInt();

		visited = new boolean[N + 1];
		tree = new LinkedList[N + 1];
		queue = new LinkedList<>();
		queue.add(A);

		for (int i = 0; i < N + 1; i++)
			tree[i] = new LinkedList();

		for (int tc = 0; tc < T; tc++) {
			int numA = sc.nextInt();
			int numB = sc.nextInt();

			tree[numA].add(numB);
			tree[numB].add(numA);
		}

		ans = 0;
		rec();

		System.out.println(ans);
	}

	static void rec() {
		if (queue.size() == 0) {
			ans = -1;
			return;
		}

		int num = -1;
		Queue<Integer> temp = new LinkedList<>();

		while (!queue.isEmpty()) {
			num = queue.poll();

			if (!visited[num]) {
				for (int i = 0; i < tree[num].size(); i++) {
					int now = tree[num].get(i);
					if (!visited[now]) {
						if (now == B) {
							ans++;
							return;
						}
						temp.add(now);
					}
				}
			}
			visited[num] = true;
		}
		ans++;
		queue.addAll(temp);
		rec();
	}
}
