import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int V, distance, farthestNode;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        visited = new boolean[V + 1];
        tree = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < V + 1; i++)
        {
            tree.add(new ArrayList<Node>());
        }
        
        for (int i = 0; i < V; i++)
        {
            st = new StringTokenizer(br.readLine());
            int nowNum = Integer.parseInt(st.nextToken());
            while(true)
            {
                
                int num = Integer.parseInt(st.nextToken());
                if (num == -1)
                    break;
                int len = Integer.parseInt(st.nextToken());
                tree.get(nowNum).add(new Node(num, len));
            }
        }

        distance = 0;
        visited[1] = true;
        search(1, 0);
        visited[1] = false;
        
        distance = 0;
        visited[farthestNode] = true;
        search(farthestNode, 0);

        bw.write(distance + "");
        bw.close();
    }
    public static void search(int nodeNum, int dist)
    {
        // find farthest node
        int cnt = 0;
        ArrayList<Node> nowNode = tree.get(nodeNum);
        for(int i = 0; i < nowNode.size(); i++)
        {
            Node node = nowNode.get(i);
            if (visited[node.num] == false)
            {
                visited[node.num] = true;
                search(node.num, dist + node.len);
                visited[node.num] = false;
                cnt++;
            }
        }
        if (cnt == 0)
        {
            if (distance < dist)
            {
                distance = dist;
                farthestNode = nodeNum;
            }
            return;
        }
    }
    static class Node
    {
        int num;
        int len;

        Node(int num, int len)
        {
            this.num = num;
            this.len = len;
        }
    }
}