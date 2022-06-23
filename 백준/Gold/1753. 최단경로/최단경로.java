import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//최단경로

class Node implements Comparable<Node>{
	int idx;
	int cost;

	Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		int start = sc.nextInt();

		ArrayList[] map = new ArrayList[V + 1];

		for (int i = 0; i < V + 1; i++) {
			map[i] = new ArrayList<Node>();
		}

		for (int e = 0; e < E; e++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			map[u].add(new Node(v, w));
		}


		int[] dist = new int[V + 1];

		for (int i = 0; i < V + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (now.cost > dist[now.idx])
				continue;

			int len = map[now.idx].size();
			for (int i = 0; i < len; i++) {
				Node next = (Node) map[now.idx].get(i);

				if (dist[next.idx] > now.cost + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					pq.add(new Node(next.idx, dist[next.idx]));
				}
			}

		}
		for (int i=1; i<=V; i++) {
        	if (dist[i] == Integer.MAX_VALUE) {
        		System.out.println("INF");
        	}
        	else {
        		System.out.println(dist[i]);
        	}
        }
	}
}