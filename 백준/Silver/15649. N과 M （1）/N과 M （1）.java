import java.util.Scanner;

//N과 M(1)
public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N];
		
		sb = new StringBuilder();
		rec(0);
	}
	static void rec(int cnt) {
		if(cnt == M) {
			System.out.println(sb);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sb.append(i+1 + " ");
				rec(cnt+1);
				visited[i] = false;
				sb.delete(cnt*2, cnt*2+2);
			}
		}
	}
}
