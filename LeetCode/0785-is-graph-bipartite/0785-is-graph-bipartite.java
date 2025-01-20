class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        boolean[] visited = new boolean[len];
        for(int i = 0; i < len; i++) {
            if (graph[i].length == 0) {
                visited[i] = true;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        boolean nowColor = true;
        while(true) {
            if (q.isEmpty()) {
                for(int i = 0; i < len; i++) {
                    if (!visited[i]) {
                        for(int node : graph[i]) {
                            q.add(node);
                        }
                        break;
                    }
                }
            }
            if (q.isEmpty()) break;

            nowColor = !nowColor;

            int size = q.size();
            while(size > 0) {
                size--;
                int now = q.poll();
                
                if (visited[now]) continue;

                visited[now] = true;
                if (nowColor)
                    color[now] = 1;
                else
                    color[now] = 2;

                for(int num : graph[now]) {
                    q.add(num);
                }
            }
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if (color[i] == color[graph[i][j]]) {
                    System.out.println(i + " " + j);
                    return false;
                }
            }
        }

        return true;
    }
}