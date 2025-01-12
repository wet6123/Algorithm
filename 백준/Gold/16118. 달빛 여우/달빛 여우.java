import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int idx;
    int weight;
    int speed;

    Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
    
    Node(int idx, int weight, int speed) {
        this.idx = idx;
        this.weight = weight;
        this.speed = speed;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Node>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node_1 = Integer.parseInt(st.nextToken()) - 1;
            int node_2 = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph[node_1].add(new Node(node_2, weight * 2));
            graph[node_2].add(new Node(node_1, weight * 2));
        }

        int[] fox_dest = new int[N];
        Arrays.fill(fox_dest, (int)16e8);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(0, 0));
        fox_dest[0] = 0;
            
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int idx = current.idx;
            int weight = current.weight;

            if (weight > fox_dest[idx]) continue;

            for(Node next : graph[idx]) {
                int next_idx = next.idx;
                int next_weight = next.weight + weight;
                
                if (next_weight < fox_dest[next_idx]) {
                    fox_dest[next_idx] = next_weight;
                    pq.offer(new Node(next_idx, next_weight));
                }
            }
        }
        
        int[][] wolf_dest = new int[2][N];
        Arrays.fill(wolf_dest[0], (int)16e8);
        Arrays.fill(wolf_dest[1], (int)16e8);

        pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(0, 0, 0));
        wolf_dest[0][0] = 0;
            
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int idx = current.idx;
            int weight = current.weight;
            int speed = current.speed;

            if (weight > wolf_dest[speed][idx]) continue;

            for(Node next : graph[idx]) {
                int next_idx = next.idx;
                int next_weight = weight + (speed == 0 ? next.weight / 2 : next.weight * 2);
                
                if (next_weight < wolf_dest[1 - speed][next_idx]) {
                    wolf_dest[1 - speed][next_idx] = next_weight;
                    pq.offer(new Node(next_idx, next_weight, 1 - speed));
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            int min_wolf = Math.min(wolf_dest[0][i], wolf_dest[1][i]);
            if (fox_dest[i] < min_wolf)
                ans++;
        }

        bw.write(ans + "\n");
        bw.close();
    }
}