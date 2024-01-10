import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//작업순서
public class Solution {
	static int[] in_degree;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			in_degree = new int[V+1];
			list = new ArrayList[V+1];
			
			for(int i = 1; i < V+1; i++) {
				list[i] = new ArrayList<>();
			}
			for(int i = 0; i < E; i++) {
				int idx = sc.nextInt();
				int des = sc.nextInt();
				list[idx].add(des);
				in_degree[des]++;
			}
			
			System.out.print("\n#" + (tc+1) + " ");
			Topological(V, E);
		}
	}

	static void Topological(int V, int E) {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i < V+1; i++) {
			if(in_degree[i] == 0) {
				System.out.print(i + " ");
				queue.add(i);
			}
		}
		while(!queue.isEmpty()) {
			int node = queue.poll();
			ArrayList<Integer> now = list[node];
			int size = now.size();
			
			for(int i = 0; i < size; i++) {
				int num = now.get(i);
				in_degree[num]--;
				if(in_degree[num] == 0) {
					System.out.print(num + " ");
					queue.add(num);
				}
			}
		}
		
	}
}
