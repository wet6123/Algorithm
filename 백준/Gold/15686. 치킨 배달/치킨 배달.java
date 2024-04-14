import java.util.*;
import java.io.*;

public class Main {
    static int cnt, N, M, ans;
    static int[][] map, coor;
    static int[][][] distance;
    static int[] dc = {0, 0, 1, -1};
    static int[] dr = {1, -1, 0, 0};
    static boolean[][] visited;
    static boolean[] index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        cnt = 0;

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2)
                    cnt++;
            }
        }

        distance = new int[N][N][cnt];
        coor = new int[cnt][2];

        cnt = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < N; j++)
            {
                if (map[i][j] == 2)
                {
                    coor[cnt][0] = i;
                    coor[cnt][1] = j;
                    cnt++;
                }
            }
        }

        for(int i = 0; i < cnt; i++)
        {
            visited = new boolean[N][N];
            search(coor[i][0], coor[i][1], i);
        }
        
        ans = Integer.MAX_VALUE;

        index = new boolean[cnt];
        permute(0, 0);

        bw.write(ans + "");
        bw.close();
    }
    static class Node
	{
		int c;
		int r;
		
		public Node(int c, int r)
		{
			this.c = c;
			this.r = r;
		}
	}
    public static void search(int c, int r, int idx)
    {
        Queue<Node> queue = new LinkedList<>();
        int cnt = 0;
        queue.add(new Node(c, r));
        distance[c][r][idx] = -1;
        
        while (queue.isEmpty() == false)
        {
            int len = queue.size();
            for(int l = 0; l < len; l++)
            {
                Node node = queue.poll();
                if (visited[node.c][node.r] == true)
                    continue;
                visited[node.c][node.r] = true;
                distance[node.c][node.r][idx] = cnt;
                for(int i = 0; i < 4; i++)
                {
                    int nc = node.c + dc[i];
                    int nr = node.r + dr[i];
        
                    if (nc >= 0 && nc < N && nr >= 0 && nr < N && visited[nc][nr] == false)
                        queue.add(new Node(nc, nr));
                }
            }
            cnt++;
        }
    }
    public static void permute(int idx, int selected)
    {
        // if (cnt - idx + selected < M)
        //     return;
        if (selected == M)
        {
            int sum = 0;
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if (map[i][j] == 1)
                    {
                        int num = Integer.MAX_VALUE;
                        for(int k = 0; k < cnt; k++)
                        {
                            if (index[k] == true)
                            {
                                if (num > distance[i][j][k])
                                    num = distance[i][j][k];
                            }
                        }
                        sum += num;
                    }
                }
            }
            if (ans > sum)
                ans = sum;
            return ;
        }
        if (idx >= cnt)
            return ;

        index[idx] = true;
        permute(idx + 1, selected + 1);
        index[idx] = false;
        permute(idx + 1, selected);
    }
}