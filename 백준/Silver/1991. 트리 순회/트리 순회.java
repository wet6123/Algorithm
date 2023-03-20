import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//트리 순회
public class Main {
	static int[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		tree = new int[T + 1][2];

		sc.nextLine();
		// 트리 생성 시작
		for (int i = 1; i <= T; i++) {
			String line = sc.nextLine();

			int node = line.charAt(0) - 64;
			int left = line.charAt(2) - 64;
			int right = line.charAt(4) - 64;
			if (left <= 0)
				left = 0;
			if (right <= 0)
				right = 0;

			// 2차원 배열에 입력
			tree[node][0] = left;
			tree[node][1] = right;
		}
		preorder(1, T);
		System.out.println();
		inorder(1, T);
		System.out.println();
		postorder(1, T);
	}

	public static void preorder(int idx, int size) {
		if (idx == 0)
			return;

		System.out.print((char) (idx + 64));
		preorder(tree[idx][0], size);
		preorder(tree[idx][1], size);
	}

	public static void inorder(int idx, int size) {
		if (idx == 0)
			return;

		inorder(tree[idx][0], size);
		System.out.print((char) (idx + 64));
		inorder(tree[idx][1], size);
	}

	public static void postorder(int idx, int size) {
		if (idx == 0)
			return;

		postorder(tree[idx][0], size);
		postorder(tree[idx][1], size);
		System.out.print((char) (idx + 64));
	}
}
