import java.util.Scanner;

//[S/W 문제해결 기본] 3일차 - String
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			int T = sc.nextInt();
			String find = sc.next();
			String str = sc.next();
			int cnt = 0;
			for(int j = 0; j <= str.length()-find.length(); j++) {
				for(int k = 0; k < find.length(); k++) {
					if(find.charAt(k) != str.charAt(j+k)) {
						break;
					}
					if(find.charAt(k) == str.charAt(j+k) && k==find.length()-1) {
						cnt++;
					}
				}
			}
			System.out.printf("#%d %d\n", T, cnt);
		}
	}
}
