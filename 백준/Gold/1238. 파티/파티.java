import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, X;
    static boolean[] visited;
    static int[] weight;
    static PriorityQueue<Node> queue;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N + 1; i++)
        {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, time));
        }

        queue = new PriorityQueue<>();

        int tmp;
        int ans = 0;

        for(int i = 1; i <= N; i++)
        {
            tmp = 0;
            
            // 파티 가기
            queue.add(new Node(i, 0));
            init();
            weight[i] = 0;
            search();
            tmp += weight[X];
            
            // 집에 오기
            queue.add(new Node(X, 0));
            init();
            weight[X] = 0;
            search();
            tmp += weight[i];

            // ans
            if (tmp > ans)
                ans = tmp;
        }
        
        bw.write(ans + "");
        bw.close();
    }

    public static void init()
    {
        weight = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++)
        {
            weight[i] = Integer.MAX_VALUE;
        }
    }
    
    public static void search()
    {
        while (queue.isEmpty() == false)
        {
            Node node = queue.poll();
            ArrayList<Node> list = graph.get(node.idx);
            int size = list.size();
            for(int i = 0; i < size; i++)
            {
                Node now = list.get(i);
                if (now.time + weight[node.idx] < weight[now.idx] && visited[now.idx] == false)
                {
                    weight[now.idx] = now.time + weight[node.idx];
                    queue.add(new Node(now.idx, weight[now.idx]));
                }
            }
            visited[node.idx] = true;        
        }
    }
    
    static class Node implements Comparable<Node>
    {
        int idx;
        int time;

        Node(int idx, int time)
        {
            this.idx = idx;
            this.time = time;
        }

        public int getIdx()
        {
            return (idx);
        }
        
        public int getTime()
        {
            return (time);
        }

        public int compareTo(Node node)
        {
            if (this.time > node.time)
                return 1;
            if (this.time < node.time)
                return -1;
            return 0;
        }
    }
}