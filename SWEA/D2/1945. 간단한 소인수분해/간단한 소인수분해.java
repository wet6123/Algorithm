import java.util.Scanner;

//간단한 소인수분해
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 2, 3, 5, 7, 11 };
		int[] cnt;
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int num = sc.nextInt();
			cnt = new int[5];
			System.out.print("#"+(i+1));
			for(int j = 0; j < 5; j++) {
				while(num%arr[j] == 0) {
					num/=arr[j];
					cnt[j]++;
				}
				System.out.printf(" %d", cnt[j]);
			}
			System.out.println();
		}
	}
}
