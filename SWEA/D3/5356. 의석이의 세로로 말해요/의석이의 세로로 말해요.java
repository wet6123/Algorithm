import java.util.Scanner;

//의석이의 세로로 말해요
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			String[] str = new String[5];
			int max = 0;
			
			for (int i = 0; i < 5; i++) {
				str[i] = sc.next();
				max = Math.max(max, str[i].length());
			}

			int idx = 0;
			while (idx < max) {
				for (int i = 0; i < 5; i++) {
					if (str[i].length() > idx) {
						sb.append(str[i].charAt(idx));
					}
				}
				idx++;
			}
			System.out.println("#" + (tc + 1) + " " + sb);
		}
	}
}
