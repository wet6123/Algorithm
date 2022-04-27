import java.util.Arrays;
import java.util.Scanner;

//수 찾기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);
		
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		out: for(int i = 0; i < M; i++) {
			int num = sc.nextInt();
			int max = N-1;
			int min = 0;
			int mid;
			
			while(min <= max) {
				mid = (max + min)/2;
				if(A[mid] == num) {
					sb.append(1).append('\n');
					continue out;
				} else if(A[mid] > num) {
					max = mid-1;
				} else {
					min = mid+1;
				}
			}
			sb.append(0).append('\n');
		}
		System.out.println(sb);
	}
}
