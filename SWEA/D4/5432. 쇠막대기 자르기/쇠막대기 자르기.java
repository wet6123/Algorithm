import java.util.Scanner;

//쇠막대기 자르기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			String str = sc.next();
			int cnt = 0;
			int ans = 0;
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') {
					cnt++;
				} else {
					cnt--;
					if(str.charAt(j-1) == '(') {
						ans+=cnt;
					} else {
						ans++;
					}
				}
			}
			System.out.println("#" + (i+1) + " " + ans);
		}
	}
}
