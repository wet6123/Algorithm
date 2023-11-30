import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//연결 요소의 개수
public class Main {
	static boolean[] visited;
	static int ans;
	static Queue<Integer> queue;
	static int N;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();

		queue = new LinkedList<>();
		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];

		ans = 0;
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList();
		}

		for (int m = 0; m < M; m++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			tree[A].add(B);
			tree[B].add(A);
		}

		graph();


		System.out.println(ans);
	}

	public static void graph() {
		if (queue.size() == 0) {
			for (int i = 1; i < N+1; i++) {
				if (!visited[i]) {
					queue.add(i);
					ans++;
					graph();
				}
			}
			return;
		}

		int num = queue.poll();

		if (!visited[num]) {
			for (int j = 0; j < tree[num].size(); j++) {
				int getNum = tree[num].get(j);
				if (getNum != num)
					queue.add(getNum);
			}
		}
		visited[num] = true;

		graph();

	}
}
