import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class graphLinkedList
{
    private ArrayList<ArrayList<Integer>> graphList;
    
    public graphLinkedList(int size)
    {
        graphList = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < size + 1; i++)
        {
            graphList.add(new ArrayList<Integer>());
        }
    }
    
    public ArrayList<ArrayList<Integer>> getGraph()
    {
        return graphList;
    }
    
    public void addEdge(int start, int end)
    {
        graphList.get(start).add(end);
    }
    
    public int getEdge(int num, int idx)
    {
        return (graphList.get(num).get(idx));
    }
    
    public int getSize(int num)
    {
        return (graphList.get(num).size());
    }
}

class Solution
{
    static Queue<Integer> queue;
    static  graphLinkedList gl;
    static int[] visited;
	public static void main(String args[]) throws Exception
    {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            gl = new graphLinkedList(100);
            visited = new int[101];
            queue = new LinkedList<>();
            
			int len = sc.nextInt();
            int start_num = sc.nextInt();
            queue.add(start_num);
            
            int ans = 0;
            
            for(int i = 0; i < len / 2; i++)
            {
                int start = sc.nextInt();
                int end = sc.nextInt();
                gl.addEdge(start, end);
            }
            
            ans = search();
            
            System.out.print("#" + test_case + " " + ans + "\n");
		}
	}
    public static int search()
    {
        int ans = 0;
        while (!queue.isEmpty())
        {
            ans = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int now = queue.poll();
                if (ans < now)
                	ans = now;
                int now_size = gl.getSize(now);
                for(int j = 0; j < now_size; j++)
                {
                    int tmp = gl.getEdge(now, j);
                    if (visited[tmp] != 1)
                    {
                    	queue.add(tmp);
                        visited[tmp] = 1;
                    }
                }
            }
        }
        return (ans);
    }
}