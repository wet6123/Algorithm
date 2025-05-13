import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] cnt = new int[N + 1];
        cnt[0] = -1;
        
        Queue<Integer>[] edges = new ArrayDeque[N + 1];
        
        for (int i = 1; i < edges.length; i++) {
            edges[i] = new ArrayDeque<>();
        }
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            cnt[end]++;
            edges[start].offer(end);
        }

        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");
            
            for(int idx : edges[now]) {
                cnt[idx]--;

                if (cnt[idx] == 0) q.offer(idx);
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
