import java.io.*;
import java.util.*;

public class Main {
	static int[][][] map;
	static int[][][] target;
	static int[][][] map_cnt;
	static int[] counter;
	static int ans;
	static int[] di = {1, -1, 0, 0, 0, 0};
	static int[] dj = {0, 0, 1, -1, 0, 0};
	static int[] dk = {0, 0, 0, 0, 1, -1};
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        map = new int[5][5][5];
        
        for(int i = 0; i < 5; i++)
        {
        	for(int j = 0; j < 5; j++)
        	{
        		st = new StringTokenizer(br.readLine());
        		for(int k = 0; k < 5; k++)
        		{
        			map[i][j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        }
        
        counter = new int[5];
        ans = Integer.MAX_VALUE;
        q = new LinkedList<>();
        
//        search
        search();
        
        if (ans == Integer.MAX_VALUE)
        	ans = -1;
        
        bw.write(ans + "");
        bw.close();
	}
	// search
	public static void search()
	{
//		check_route
		check_route();
//		rotate
		counter[0]++;
		rotate(0);
		for(int i = 0; i < 5; i++)
		{
			if(counter[i] >= 4)
			{
				if (i >= 4)
					return;
				else
				{
					counter[i + 1]++;
					counter[i] = 0;
					rotate(i + 1);
				}
			}
		}
		search();
	}
	// check_route
	public static void check_route()
	{
		// combination
		target = new int[5][5][5];
		boolean[] selected = new boolean[5];
		combination(0, selected);
	}
	public static void combination(int idx, boolean[] selected)
	{
		if (idx == 5)
		{
			// valid_check
			if (target[0][0][0] != 1 || target[4][4][4] != 1)
			{
				return ;
			}
			// search_route
			map_cnt = new int[5][5][5];
			for(int i = 0; i < 5; i++)
	        {
	        	for(int j = 0; j < 5; j++)
	        	{
	        		for(int k = 0; k < 5; k++)
	        		{
	        			map_cnt[i][j][k] = Integer.MAX_VALUE;
	        		}
	        	}
	        }
			search_route(0, 0, 0);
			return ;
		}
		for(int map_idx = 0; map_idx < 5; map_idx++)
		{
			if (selected[map_idx] == false)
			{
				selected[map_idx] = true;
				for(int i = 0; i < 5; i++)
				{
					for(int j = 0; j < 5; j++)
					{
						target[idx][i][j] = map[map_idx][i][j];
					}
				}
				combination(idx + 1, selected);
				selected[map_idx] = false;
			}
		}
	}
	// search_route
	public static void search_route(int i, int j, int k)
	{
		map_cnt[0][0][0] = 0;
		q.add(new Node(0, 0, 0));
		// bfs
		while(q.isEmpty() == false)
		{
			int size = q.size();
    		for(int q_size = 0; q_size < size; q_size++) {
    			Node node = q.poll();
    			int val = map_cnt[node.x][node.y][node.z];
    			for(int x = 0; x < 6; x++)
    			{
    				int ni = node.x + di[x];
    				int nj = node.y + dj[x];
    				int nk = node.z + dk[x];
    				if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5 && nk >= 0 && nk < 5)
    				{
    					if (map_cnt[ni][nj][nk] > val + 1 && target[ni][nj][nk] == 1)
    					{
    						map_cnt[ni][nj][nk] = val + 1;
    						q.add(new Node(ni, nj, nk));
    					}
    				}
    			}
    		}
		}
		// ans_set
		if (ans > map_cnt[4][4][4])
			ans = map_cnt[4][4][4];
		return ;
	}
	// rotate
	public static void rotate(int target_num)
	{
		int[][] tmp = new int[5][5];
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				tmp[j][5 - 1 - i] = map[target_num][i][j];
			}
		}
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				map[target_num][i][j] = tmp[i][j];
			}
		}
	}
	static class Node {
		int x;
    	int y;
    	int z;
    	
    	public Node(int x, int y, int z) {
    		this.x = x;
    		this.y = y;
    		this.z = z;
    	}
	}
}
