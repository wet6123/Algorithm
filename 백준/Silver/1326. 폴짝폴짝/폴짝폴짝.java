import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ans, N, a, b, cnt, now;
        int[] map;
        boolean[] visited;
        Queue<Integer> queue;
        
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        map = new int[N];
        visited = new boolean[N];
        queue = new LinkedList<>();
        
        for(int i = 0; i < N; i++)
        {
            map[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (a == b)
        {
            bw.write("0");
            bw.close();
            return;
        }

        ans = Integer.MAX_VALUE;
        cnt = 1;
        
        now = a - 1;
        visited[now] = true;
        int i = 1;
        while (now + map[now] * i < N)
        {
            queue.add(now + map[now] * i);
            i++;
        }
        i = 1;
        while (now - map[now] * i >= 0)
        {
            queue.add(now - map[now] * i);
            i++;
        }
        
        all:while (queue.isEmpty() == false)
        {
            int len = queue.size();
            while (len > 0)
            {
                now = queue.poll();
                visited[now] = true;
                if (now == b - 1)
                {
                    ans = cnt;
                    break all;
                }
                
                i = 1;
                while (now + map[now] * i < N)
                {
                    if (visited[now + map[now] * i] == false)
                        queue.add(now + map[now] * i);
                    i++;
                }
                i = 1;
                while (now - map[now] * i >= 0)
                {
                    if (visited[now - map[now] * i] == false)
                        queue.add(now - map[now] * i);
                    i++;
                }
                len--;
            }
            cnt++;
        }

        if (ans == Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(ans + "");
        bw.close();
    }
}