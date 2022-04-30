import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//케빈 베이컨의 6단계 법칙
public class Main {
	static ArrayList<Integer>[] list;
	static int N;
	static int[] kbNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();

		kbNum = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) { // 친구 연결 정보 저장 배열리스트
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) { // 친구 연결 정보 저장
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}

		for (int i = 1; i < N + 1; i++) {
			find(i);
		}
		int min = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 1; i < N + 1; i++) {
			if (min > kbNum[i]) {
				min = kbNum[i];
				ans = i;
			}
		}
		System.out.println(ans);
	}

	static void find(int idx) {
		int[] value = new int[N + 1];
		Arrays.fill(value, Integer.MAX_VALUE);
		value[idx] = 0;

		Queue<Integer> queue = new LinkedList<>();
		int size = list[idx].size();
		for (int i = 0; i < size; i++) {
			queue.add(list[idx].get(i));
		}
		int num = 0;
		while (size != 0) {
			num++;
			for (int i = 0; i < size; i++) {
				int now = queue.poll();
				if (value[now] > num) {
					value[now] = num;
					queue.addAll(list[now]);
				}
			}
			size = queue.size();
		}
		for(int i = 1; i < N+1; i++) {
			kbNum[idx] += value[i];
		}
	}
}
