import java.util.Scanner;

//새로운 불면증 치료법
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[10];
			int cnt = 0;
			
			while(true) {
				cnt++;
				int num = N*cnt;
				while(num>9) {
					arr[num%10] = 1;
					num/=10;
				}				
				arr[num] = 1;
				
				int sum = 0;
				for(int j = 0; j < 10; j++) {
					sum += arr[j];
					if(arr[j]==0)break;
				}
				if(sum == 10)break;
			}
			System.out.println("#" + (i+1) + " " + N*cnt);
		}
	}
}
