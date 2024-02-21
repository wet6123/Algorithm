import java.util.Scanner;

//성공적인 공연 기획
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			String str = sc.next();
			int sum = 0;
			int cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				int num = str.charAt(i)-'0';
				sum += num;
				if (sum < i+1) {
					cnt++;
					sum++;
				}
			}
			System.out.println("#" + (tc+1) + " " + cnt);
		}
	}
}
