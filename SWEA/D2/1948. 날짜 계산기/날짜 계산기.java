import java.util.Scanner;

//날짜 계산기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		for (int i = 0; i < T; i++) {
			int ans = 0;
			int[] arr = new int[4];
			for (int j = 0; j < 4; j++) {
				arr[j] = sc.nextInt();
			}
			if(arr[0]==arr[2])
				ans = arr[3] - arr[1] + 1;
			else {				
				ans += days[arr[0]] - arr[1] + 1;
				arr[0]++;
				while (arr[0] < arr[2])
					ans += days[arr[0]++];
				ans += arr[3];
			}
			
			System.out.println("#" + (i+1) + " " + ans);
		}
	}
}
