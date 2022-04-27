import java.util.Scanner;

//소수 구하기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] arr = new boolean[N+1];
		
		arr[0] = arr[1] = true;
		
		for(int i = 2; i*i <= N; i++) {
			if(!arr[i]) {
				for(int j = i*i; j <= N; j+=i)
					arr[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = M; i <= N; i++) {
			if(!arr[i])sb.append(i).append('\n');
		}
		System.out.println(sb);
	}
}
