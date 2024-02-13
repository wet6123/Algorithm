import java.util.Scanner;

//지그재그 숫자
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int num = sc.nextInt();
			int ans = 0;
			for(int j = 1; j <= num; j++) {
				if(j%2 == 0) {
					ans-=j;
				} else {
					ans+=j;
				}
			}
			System.out.println("#" + (i+1) + " " + ans);
		}
	}
}
