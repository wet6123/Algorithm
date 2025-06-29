import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[100001];
        int[] parent = new int[100001];
        Arrays.fill(visited, -1);
        Arrays.fill(parent, -1);

        q.offer(N);
        visited[N] = 0;

        while(!q.isEmpty()) {
            int current = q.poll();

            if(current == K) {
                bw.write(visited[K] + "\n");
                break;
            }

            int[] index = {current - 1, current + 1, current * 2};
                
            for(int next: index) {
                if (next >= 0 && next <= 100000 &&  visited[next] == -1) {
                    visited[next] = visited[current] + 1;
                    parent[next] = current;
                    q.offer(next);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int pos = K;
        while(true) {
            if (pos == N) {
                path.add(N);
                break;
            }
            path.add(pos);
            pos = parent[pos];
        }
        
        Collections.reverse(path);
        
        for(int i = 0; i < path.size(); i++) {
            bw.write(path.get(i) + "");
            if(i < path.size() - 1) bw.write(" ");
        }
        
        bw.close();
    }
}