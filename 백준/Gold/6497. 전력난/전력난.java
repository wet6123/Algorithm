import java.util.*;
import java.lang.*;
import java.io.*;

class Edge {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static int[] parents;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        all: while(true) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break all;
    
            int total = 0;
            int sum = 0;
    
            PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
    
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
    
                
                int weight = Integer.parseInt(st.nextToken());
    
                total += weight;
                
                pq.offer(new Edge(start, end, weight));
            }
    
            parents = new int[m];
            for(int i = 0; i < m; i++) {
                parents[i] = i;
            }
    
            int cnt = 0;
            while(cnt < m - 1 && !pq.isEmpty()) {
                Edge now = pq.poll();
    
                int rootStart = findPar(now.start);
                int rootEnd = findPar(now.end);
    
                if (rootStart != rootEnd) {
                    union(rootStart, rootEnd, m);
                    cnt++;
                    sum += now.weight;
                }
            }
    
            bw.write((total - sum) + "\n");
        }
        bw.close();
    }
    public static int findPar(int idx) {
        if(parents[idx] != idx) {
            parents[idx] = findPar(parents[idx]);
        }

        return (parents[idx]);
    }

    public static void union(int start, int end, int m) {
        if (start > end) {
            for(int i = 0; i < m; i++) {
                if (parents[i]  == start) parents[i] = end;
            }
        } else if (start < end) {
            for(int i = 0; i < m; i++) {
                if (parents[i]  == end) parents[i] = start;
            }
            
        }
    }
}