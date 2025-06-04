import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        int[] order = new int[N];
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        
        bw.write(isValidBFS(N, graph, order) ? "1" : "0");
        bw.close();
    }

    public static boolean isValidBFS(int n, List<List<Integer>> graph, int[] order) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(1);
        visited[1] = true;
        
        int orderIndex = 1;
        
        while (!queue.isEmpty() && orderIndex < n) {
            int current = queue.poll();
            
            List<Integer> availableNodes = new ArrayList<>();
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    availableNodes.add(neighbor);
                }
            }
            
            for (int node : availableNodes) {
                visited[node] = true;
            }
            
            if (orderIndex + availableNodes.size() > n) {
                return false;
            }
            
            Set<Integer> availableSet = new HashSet<>(availableNodes);
            for (int i = 0; i < availableNodes.size(); i++) {
                if (!availableSet.contains(order[orderIndex + i])) {
                    return false;
                }
            }
            
            for (int i = 0; i < availableNodes.size(); i++) {
                queue.offer(order[orderIndex + i]);
            }
            
            orderIndex += availableNodes.size();
        }
        
        return orderIndex == n;
    }
}