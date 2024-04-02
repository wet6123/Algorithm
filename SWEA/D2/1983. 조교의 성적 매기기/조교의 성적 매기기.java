import java.util.Scanner;

//조교의 성적 매기기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-","C+","C0","C-","D0"};
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			double[] arr = new double[N];
			for(int j = 0; j < N; j++) {
				
				arr[j] = sc.nextInt()*0.35 + sc.nextInt()*0.45 + sc.nextInt()*0.2;
			}
			double Score = arr[K-1];
			int idx = 0;
			for(int j = N-1; j >= 0; j--) {
				for(int k = 0; k < j; k++) {
					if(arr[idx]<arr[k])idx = k;
				}
				if(Score == arr[idx]) {
					System.out.printf("#%d %s\n", i+1, grade[9-(int)j/(N/10)]);
				}
				double tmp = arr[idx];
				arr[idx] = arr[j];
				arr[j] = arr[idx];
			}
		}
	}
}
