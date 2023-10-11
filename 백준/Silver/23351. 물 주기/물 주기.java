import java.util.Scanner;

//물주기
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int[]arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = K;
		}
		
		int cnt = 0;
		total: while(true) {
			for(int i = 0; i < N; i++) {
				if(arr[i]<=0) {
					System.out.println(cnt);
					break total;
				}
			}
			cnt++;
				
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for(int i = 0; i <= N-A; i++) {
				int sum = 0;
				for(int j = 0; j < A; j++) {
					sum+=arr[i+j];
				}
				if(sum<min) {
					min=sum;
					idx = i;
				}
			}
			for(int j = idx; j < idx+A; j++) {
				arr[j]+=B;
			}
			for(int i = 0; i < N; i++) {
				arr[i]--;
			}
		}
	}
}
