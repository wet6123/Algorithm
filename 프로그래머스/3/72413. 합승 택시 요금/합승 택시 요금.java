import java.util.*;

class Node {
    int dest;
    int weight;
    
    Node(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class Solution {
    static int[] d;
    static boolean[] v;
    static ArrayList<Node>[] map;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        map = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < fares.length; i++) {
            int start = fares[i][0] - 1;
            int end = fares[i][1] - 1;
            int fare = fares[i][2];
            
            map[start].add(new Node(end, fare));
            map[end].add(new Node(start, fare));
        }
        
        int[] ds = Daijkstra(n, s - 1);
        int[] da = Daijkstra(n, a - 1);
        int[] db = Daijkstra(n, b - 1);

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int sum = ds[i] + da[i] + db[i];
            if (sum < answer)
                answer = sum;
        }
        
        return answer;
    }
    
    public int[] Daijkstra(int n, int start) {
        d = new int[n];
        v = new boolean[n];
        Arrays.fill(d, (int)1e8);
        d[start] = 0;
        v[start] = true;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.dest;
            int fare = current.weight;
            
            if (d[now] < fare) continue;
            
            for(Node node : map[now]) {
                if(fare + node.weight < d[node.dest]) {
                    d[node.dest] = fare + node.weight;
                    pq.offer(new Node(node.dest, fare + node.weight));
                }
            }
        }
        return d;
    }
}