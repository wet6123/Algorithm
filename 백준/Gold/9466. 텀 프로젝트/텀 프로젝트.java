import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static boolean[] isTeam;
    static boolean[] currentVisited;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            nums = new int[n + 1];
            
            for(int i = 1; i <= n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            bw.write(studentsWithoutTeam(n) + "\n");
        }
        

        bw.flush();
        bw.close();
    }

    public static int studentsWithoutTeam(int n) {
        visited = new boolean[n + 1];
        isTeam = new boolean[n + 1];
        currentVisited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            if (!visited[i]) dfs(i);
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if (!isTeam[i]) ans++;
        }

        return ans;
    }

    public static void dfs(int idx) {
        visited[idx] = true;
        currentVisited[idx] = true;

        int nextIdx = nums[idx];

        if (!visited[nextIdx]) {
            dfs(nextIdx);
        }

        if (currentVisited[nextIdx]) {
            int current = nextIdx;
            while (true) {
                isTeam[current] = true;
                current = nums[current];
                if (current == nextIdx) break;
            }
        }
        
        currentVisited[idx] = false;
    }
}