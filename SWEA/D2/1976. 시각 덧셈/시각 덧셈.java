import java.util.Scanner;

//시각 덧셈
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int[] arr = new int[4];
			for(int j = 0; j < 4; j++)arr[j] = sc.nextInt();
			
			arr[1] += arr[3];
			if(arr[1] > 60) {
				arr[1] -= 60;
				arr[0]++;
			}
			
			arr[0] += arr[2];
			while(arr[0] > 12) {
				arr[0] -= 12;
			}
			
			System.out.printf("#%d %d %d\n", i+1, arr[0], arr[1]);
		}
	}
}
