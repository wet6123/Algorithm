import java.util.Scanner;
import java.io.FileInputStream;
import java.util.PriorityQueue;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[][] island = new int [N][2];
            for(int i = 0; i < N; i++)
            {
                island[i][0] = sc.nextInt();
            }
            for(int i = 0; i < N; i++)
            {
                island[i][1] = sc.nextInt();
            }
            double E = sc.nextDouble();
            
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for(int i = 0; i < N; i++)
            {
                for(int j = i + 1; j < N; j++)
                {
                    double dx = island[i][0] - island[j][0];
                    double dy = island[i][1] - island[j][1];
                    double distance = Math.sqrt(dx * dx + dy * dy);
                    pq.add(new Node(i, j, distance));
                }
            }
            
            int[] union_find = new int[N];
            for(int i = 0; i < N; i++)
            {
                union_find[i] = i;
            }
            
            double answer = 0;
            
            while (!pq.isEmpty()) {
                int flag = 0;
               	for(int i = 1; i < N; i++)
                {
                    if(union_find[0] != union_find[i])
                    {
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0)
                    break;
                
                Node node = pq.poll();
                if (union_find[node.getA()] != union_find[node.getB()])
                {
                    answer += node.getDistance() * node.getDistance();
                    int tmp = union_find[node.getB()];
                    for(int i = 0; i < N; i++)
                    {
                        if (tmp == union_find[i])
                        	union_find[i] = union_find[node.getA()];
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + Math.round(E * answer));
		}
	}
    static class Node implements Comparable<Node>
    {
        private int a, b;
        private double distance;
        
        public Node(int a, int b, double distance)
        {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }
        
        public int getA() {
            return (this.a);
        }
        public int getB() {
            return (this.b);
        }
        public double getDistance() {
            return (this.distance);
        }
        
        public int compareTo(Node node) {
            if (this.distance > node.getDistance())
                return 1;
            if (this.distance < node.getDistance())
                return -1;
            return 0;
        }
    }
}