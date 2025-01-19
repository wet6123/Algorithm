import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int idx;
    int weight;

    Node (int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        
        boolean[] visited = new boolean[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, W));
            list[B].add(new Node(A, W));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(1, 0));
        int dist = 0;
        int max = 0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIdx = current.idx;
            int currentWeight = current.weight;

            if (visited[currentIdx]) continue;
            
            visited[currentIdx] = true;

            max = Math.max(max, currentWeight);

            dist += currentWeight;

            for(Node next : list[currentIdx]) {
                if (visited[next.idx] == false) {
                    pq.offer(new Node(next.idx, next.weight));
                }
            }
        }
        bw.write((dist - max) + "\n");
        bw.close();
    }
}