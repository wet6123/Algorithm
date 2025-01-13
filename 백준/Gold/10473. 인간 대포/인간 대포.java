import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int idx;
    float weight;

    Node(int idx, float weight) {
        this.idx = idx;
        this.weight = weight;
    }
}

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        float startX = Float.parseFloat(st.nextToken());
        float startY = Float.parseFloat(st.nextToken());
        st = new StringTokenizer(br.readLine());
        float endX = Float.parseFloat(st.nextToken());
        float endY = Float.parseFloat(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) + 2;
        float[][] coors = new float[n][2];
        
        coors[0][0] = startX;
        coors[0][1] = startY;
        coors[n - 1][0] = endX;
        coors[n - 1][1] = endY;
        for(int i = 1; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            coors[i][0] = Float.parseFloat(st.nextToken());
            coors[i][1] = Float.parseFloat(st.nextToken());
        }

        ArrayList<Node>[] map = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            map[i] = new ArrayList<Node>();
        }

        for(int idx = 0; idx < n; idx++) {
            for(int i = 0; i < n; i++) {
                if (i == idx) continue;
                float powX = (float)Math.pow(coors[i][0] - coors[idx][0], 2);
                float powY = (float)Math.pow(coors[i][1] - coors[idx][1], 2);
                float dis = (float)Math.sqrt(powX + powY);
                // 처음과 끝은 대포 없음
                if (idx == 0 || idx == n - 1) {
                    map[idx].add(new Node(i, dis));
                } else if (dis >= 50) {
                // 50 이상
                    map[idx].add(new Node(i, dis - 40));
                } else {
                // 50 미만
                    if (dis >= 30) {
                    // 30 이상 -> 대포 타고 걸어감(10m + (50m - dis))
                        map[idx].add(new Node(i, 10 + (50 - dis)));
                    } else {
                    // 30 미만 -> 그냥 걸아감
                        map[idx].add(new Node(i, dis));
                    }
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Float.compare(a.weight, b.weight));
        pq.offer(new Node(0, 0));
        float[] dist = new float[n];
        Arrays.fill(dist, (float)1e8);
        dist[0] = 0;

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int curIdx = current.idx;
            float curW = current.weight;

            if (curW > dist[curIdx]) continue;

            for(Node next : map[curIdx]) {
                int nextIdx = next.idx;
                float nextW = curW + next.weight;
                
                if (nextW < dist[nextIdx]) {
                    dist[nextIdx] = nextW;
                    pq.offer(new Node(nextIdx, nextW));
                }
            }
        }

        float ans = dist[n - 1] / 5;
        
        bw.write(ans + "\n");
        bw.close();
    }
}