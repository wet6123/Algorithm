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
        StringTokenizer st;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int p_index = 0;
        ArrayList<Node>[] graph;

        while(true) {
            p_index++;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0)
                break;

            graph = new ArrayList[n * n];
            for(int i = 0; i < n * n; i++) {
                graph[i] = new ArrayList<>();
            }
            
            int[][] map = new int[n][n];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                }
            }
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int idx = 0; idx < 4; idx++) {
                        int nx = j + dx[idx];
                        int ny = i + dy[idx];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            graph[i * n + j].add(new Node(ny * n + nx, map[ny][nx]));
                        }
                    }
                    // for (Node item : graph[i * n + j]) {
                    //     bw.write(item.idx + " ");
                    // }
                    // bw.write("\n");
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
            pq.offer(new Node(0, map[0][0]));
            int[] dest = new int[n * n];
            for(int idx = 0; idx < n * n; idx++) {
                dest[idx] = (int) 1e9;
            }
    
            while(!pq.isEmpty()) {
                Node current = pq.poll();
    
                if (current.weight > dest[current.idx]) continue;
    
                for(Node next : graph[current.idx]) {
                    int cost = next.weight + current.weight;
    
                    if (cost < dest[next.idx]) {
                        dest[next.idx] = cost;
                        pq.offer(new Node(next.idx, cost));
                    }
                }
            }

            bw.write("Problem " + p_index + ": " + dest[n * n - 1] + "\n");
        }
        bw.close();
    }
}