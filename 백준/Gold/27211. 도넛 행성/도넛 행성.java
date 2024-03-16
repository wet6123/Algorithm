import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N;
	static int M;
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new int[N][M];
        
        for(int i = 0; i < N; i++)
        {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < M; j++)
        	{
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        q = new LinkedList<>();
        int ans = 0;
        
        for(int i = 0; i < N; i++)
        {
        	for(int j = 0; j < M; j++)
        	{
        		if (visited[i][j] == 0 && map[i][j] == 0)
        		{
        			q.add(new Node(j, i));
        			bfs();
        			ans++;
        		}
        	}
        }
        
        bw.write(ans + "");
        bw.close();
	}
	static void bfs()
	{
		while(!q.isEmpty())
		{
			Node now = q.poll();
			for(int i = 0; i < 4; i++)
			{
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (nx < 0)
					nx = M - 1;
				if (ny < 0)
					ny = N - 1;
				if (nx == M)
					nx = 0;
				if (ny == N)
					ny = 0;
				
				if (visited[ny][nx] == 0 && map[ny][nx] == 0)
				{
					visited[ny][nx] = 1;
					q.add(new Node(nx, ny));
				}
			}
		}
	}
	static class Node
	{
		int x;
		int y;
		
		public Node(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}
