import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static ArrayList<LinkedList<Integer>> list;
    static boolean[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>(N + 1);
        map = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new LinkedList<>());
        }

        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }
        
        dfs(1);

        int ans = 0;
        
        for (int i = 2; i < N + 1; i++) {
            if (map[i]) ans++;
        }
        
        bw.write(ans + "");
        bw.close();
    }

    private static void dfs(int idx) {
        if (map[idx]) return;

        map[idx] = true;

        for(int next : list.get(idx)) {
            dfs(next);
        }
    }
}