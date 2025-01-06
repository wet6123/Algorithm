import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int idx;
    int weight;

    Node(int idx, int weight) {
        this.idx = idx;
        this.weight = weight;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] map = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int sIdx = Integer.parseInt(st.nextToken()) - 1;
            int eIdx = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            map[sIdx].add(new Node(eIdx, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        int[] dest = new int[n];
        int[] pastNode = new int[n];
        Arrays.fill(dest, (int)1e9+7);
        Arrays.fill(pastNode, (int)1e9+7);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(start, 0));
        dest[start] = 0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int idx = current.idx;
            int weight = current.weight;

            if (weight > dest[idx])
                continue;

            for(Node next : map[idx]) {
                int nextIdx = next.idx;
                int nextWeight = next.weight + dest[idx];

                if (nextWeight < dest[nextIdx]) {
                    dest[nextIdx] = nextWeight;
                    pq.offer(new Node(nextIdx, nextWeight));
                    pastNode[nextIdx] = idx;
                }
            }
        }

        String str = "";
        int cnt = 1;
        int idx = end;
        while (idx != start) {
            str = (pastNode[idx] + 1) + " " + str;
            idx = pastNode[idx];
            cnt++;
        }
        str = str + (end + 1);

        bw.write(dest[end] + "\n");
        bw.write(cnt + "\n");
        bw.write(str + "\n");
        bw.close();
    }
}