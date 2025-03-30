import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[] times = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }
            
            ArrayList<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            
            int[] inDegree = new int[N + 1];
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                inDegree[Y]++;
            }
            
            int W = Integer.parseInt(br.readLine());
            
            int[] dp = new int[N + 1];
            Queue<Integer> queue = new LinkedList<>();
            
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    dp[i] = times[i];
                }
            }
            
            while (!queue.isEmpty()) {
                int current = queue.poll();
                
                for (int next : graph[current]) {
                    inDegree[next]--;
                    
                    dp[next] = Math.max(dp[next], dp[current] + times[next]);
                    
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            
            System.out.println(dp[W]);
        }
        
        br.close();
    }
}