import java.io.*;
import java.util.*;

public class Main {
	static int H;
	static int W;
	static char[][] map;
	static int[][][] cnt;
	static int[][] coor;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static Queue<Node> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int test_case = Integer.parseInt(st.nextToken());
        for(int tc = 0; tc < test_case; tc++)
        {
        	st = new StringTokenizer(br.readLine());
        	H = Integer.parseInt(st.nextToken()) + 2;
        	W = Integer.parseInt(st.nextToken()) + 2;
        	map = new char[H][W];
        	cnt = new int[H][W][4];
        	coor = new int[2][3];
        	q = new LinkedList<>();
        	
        	coor[0][2] = 0;
        	coor[1][2] = 0;
        	int p_cnt = 0;
        	for(int h = 0; h < H; h++)
        	{
        		if(h == 0 || h == H - 1)
        		{
        			for(int w = 0; w < W; w++)
        			{
    					map[h][w] = '.';
        				cnt[h][w][0] = H*W;
        				cnt[h][w][1] = H*W;
        				cnt[h][w][2] = H*W;
        				cnt[h][w][3] = 0;
        			}
        		}
        		else
        		{
        			st = new StringTokenizer(br.readLine());
        			String tmp = st.nextToken();
        			for(int w = 0; w < W; w++)
        			{
        				if (w == 0 || w == W - 1)
        					map[h][w] = '.';
        				else
        					map[h][w] = tmp.charAt(w - 1);
        				cnt[h][w][0] = H*W;
        				cnt[h][w][1] = H*W;
        				cnt[h][w][2] = H*W;
        				cnt[h][w][3] = 0;
        				
        				if (map[h][w] == '$') {
        					coor[0][p_cnt] = w;
        					coor[1][p_cnt] = h;
        					p_cnt++;
        				}
        			}
        		}
        	}
        	
        	search();
        	
        	int ans = Integer.MAX_VALUE;
        	
    		for(int i = 0; i < H; i++) {
    			for(int j = 0; j < W; j++) {
    				if (cnt[i][j][3] < ans && cnt[i][j][3] >= 0)
    					ans = cnt[i][j][3];
    			}
    		}
    		
//    		for(int i = 0; i < H; i++) {
//    			for(int j = 0; j < W; j++) {
//    				bw.write(cnt[i][j][3] + "");
//    			}
//    			bw.write("\n");
//    		}
        	
        	bw.write(ans + "\n");
        }
        bw.close();
    }
    public static void search() {
    	for(int i = 0; i < 3; i++) {
			bfs(coor[0][i], coor[1][i], i);
    	}
    	
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				for(int k = 0; k < 3; k++) {
					cnt[i][j][3] += cnt[i][j][k];
				}
				if (map[i][j] == '#')
					cnt[i][j][3] -= 2;
			}
		}
    }
    public static void bfs(int x, int y, int n)
    {
    	q.add(new Node(x, y));
    	cnt[y][x][n] = 0;
    	while(q.isEmpty() == false)
    	{
    		int size = q.size();
    		for(int i = 0; i < size; i++) {
    			Node node = q.poll();
    			int val = cnt[node.y][node.x][n];
    			for(int j = 0; j < 4; j++) {
    				int nx = node.x + dx[j];
    				int ny = node.y + dy[j];
    				if (nx >= 0 && nx < W && ny >= 0 && ny < H)
    				{
    					int nv = val;
    					if (map[ny][nx] == '#')
							nv++;
    					
    					if (map[ny][nx] != '*' && cnt[ny][nx][n] > nv)
    					{
    						q.add(new Node(nx, ny));
							cnt[ny][nx][n] = nv;
    					}
    				}
    			}
    		}
    	}
    }
    static class Node {
    	int x;
    	int y;
    	
    	public Node(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}
