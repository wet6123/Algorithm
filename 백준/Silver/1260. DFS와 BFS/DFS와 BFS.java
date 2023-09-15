import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS와 BFS
public class Main {
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		map = new ArrayList[N+1];
		
		for(int n = 1; n < N+1; n++)
			map[n] = new ArrayList<>();
		
		for(int m = 0; m < M; m++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			map[A].add(B);
			map[B].add(A);
		}
		for(int n = 1; n < N+1; n++)
			map[n].sort(Comparator.naturalOrder());
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		queue = new LinkedList<Integer>();
		bfs(V);
		System.out.println();
	}
	
	static void dfs(int idx) {
		if(visited[idx])
			return;
		
		visited[idx] = true;
		System.out.print(idx + " ");
		for(int i = 0; i < map[idx].size(); i++) {
			if(map[idx].get(i) != idx)
				dfs(map[idx].get(i));
		}
	}
	
	static void bfs(int idx) {
		if(visited[idx])
			return;
		
		visited[idx] = true;
		System.out.print(idx + " ");
		for(int i = 0; i < map[idx].size(); i++) {
			if(map[idx].get(i)  != idx)
				queue.add(map[idx].get(i));
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(visited[now])
				continue;
			
			visited[now] = true;
			
			System.out.print(now + " ");
			for(int i = 0; i < map[now].size(); i++) {
				if(map[now].get(i) != now)
					queue.add(map[now].get(i));
			}
		}
	}
}
