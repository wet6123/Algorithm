import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
class Solution
{
    static int[][] map;
    static int[][] visited;
    static Queue<Node> stack;
    static int ans;
    static int N;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
            map = new int[N][N];
            visited = new int[N][N];
            stack = new LinkedList<>();
            ans = 0;
            for(int i = 0; i < N; i++)
            {
                String str = sc.next();
                for(int j = 0; j < N; j++)
                {
                    visited[i][j] = 0;
                    map[i][j] = str.charAt(j);
                }
            }
            // set num;
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if(map[i][j] != '*')
                    {
                        int cnt = 0;
                        for(int k = 0; k < 8; k++)
                        {
                            int nx = j + dx[k];
                            int ny = i + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N)
                            {
                                if(map[ny][nx] == '*')
                                    cnt++;
                            }
                        }
                        map[i][j] = cnt;
                    }
                }
            }
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if (map[i][j] == 0)
                    {
                        stack.add(new Node(j, i));
                    }
                }
            }
            // remove zero
            remove_zero();
            // search non zero
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    if(map[i][j] != '*' && visited[i][j] != 1)
                    {
                        ans++;
                    }
                }
            }
            // print ans
            System.out.println("#" + test_case + " " + ans);
        }
	}
    public static void remove_zero()
    {
        while (stack.size() > 0)
        {
        	Node now = stack.poll();
            if (visited[now.y][now.x] != 1)
            {
        		open_near_zero(now.x, now.y);
                ans++;
            }
        }
    }
    public static void open_near_zero(int x, int y)
    {
        visited[y][x] = 1;
        for(int i = 0; i < 8; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N)
            {
                if (visited[ny][nx] != 1 && map[ny][nx] == 0)
                {
                    open_near_zero(nx, ny);
                }
                if (visited[ny][nx] != 1 && map[ny][nx] != '*')
                    visited[ny][nx] = 1;
            }
        }
    }
}