import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

class Node {
    int dest;
    int weight;
    
    Node(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    } 
}

public class Main {
    static ArrayList<Node>[] map;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()) - 1;
        
        map = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            map[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            map[u].add(new Node(v, w));
        }
        
        int[] ans = Dijkstra(V, K);
        
        for(int num : ans) {
            if (num == (int)1e8)
                bw.write("INF\n");
            else
                bw.write(num + "\n");
        }
        bw.close();
    }
    
    public static int[] Dijkstra(int numOfNodes, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] dest = new int[numOfNodes];
        Arrays.fill(dest, (int)1e8);
        dest[start] = 0;
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int idx = now.dest;
            int weight = now.weight;
            
            if (weight > dest[idx]) continue;
            
            for(Node next : map[idx]) {
                int nextIdx = next.dest;
                int nextWeight = weight + next.weight;
                if(nextWeight < dest[nextIdx]) {
                    dest[nextIdx] = nextWeight;
                    pq.offer(new Node(nextIdx, nextWeight));
                }
            }
        }
        
        return dest;
    }
}