import java.util.Scanner;

//크로아티아 알파벳
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i + 1 < str.length()) {
				if (str.charAt(i) == 'c') {
					switch (str.charAt(i + 1)) {
					case '=':
						cnt++;
						i++;
						break;

					case '-':
						cnt++;
						i++;
						break;

					default:
						cnt++;
						break;
					}
				} else if (str.charAt(i) == 'd') {
					if ((i + 2) < str.length() && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
						cnt++;
						i += 2;
					} else if (str.charAt(i + 1) == '-') {
						cnt++;
						i++;
					} else
						cnt++;
				} else if (str.charAt(i) == 'l') {
					if (str.charAt(i + 1) == 'j') {
						cnt++;
						i++;
					} else
						cnt++;
				} else if (str.charAt(i) == 'n') {
					if (str.charAt(i + 1) == 'j') {
						cnt++;
						i++;
					} else
						cnt++;
				} else if (str.charAt(i) == 's') {
					if (str.charAt(i + 1) == '=') {
						cnt++;
						i++;
					} else
						cnt++;
				} else if (str.charAt(i) == 'z') {
					if (str.charAt(i + 1) == '=') {
						cnt++;
						i++;
					} else
						cnt++;
				} else {
					cnt++;
				}
			} else {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
