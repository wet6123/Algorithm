import java.util.*;
import java.awt.Point;
import java.io.FileInputStream;

class Solution
{
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int[][] map;
    static int[][] input;
    static Queue<Point> queue;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            
            N = sc.nextInt();
            map = new int[N][N];
            input = new int[N][N];
            queue = new LinkedList<>();
            
            for(int i = 0; i < N; i++)
            {
            	String tmp = sc.next();
                for(int j = 0; j < N; j++)
                {
                    input[i][j] = Integer.parseInt(tmp.substring(j, j + 1));
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
            map[0][0] = 0;
            queue.add(new Point(0, 0));
            
            search();
            
			System.out.println("#" + test_case + " " + map[N - 1][N - 1]);
		}
	}
	public static void search()
	{
		while(!queue.isEmpty())
		{
			Point p = queue.poll();
			for(int i = 0; i < 4; i++)
			{
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if(x >= 0 && x < N && y >= 0 && y < N )
				{
					int next = map[p.x][p.y] + input[x][y];
					if(map[x][y] > next)
					{
						map[x][y] = next;
						queue.add(new Point(x, y));
					}
				}
			}
		}
	}
}