import java.util.Scanner;

// 바닥장식
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		char[][] arr = new char[y][x];
		
		char before = '.';
		char now;
		String line;
		
		int ans = 0;
		
		for(int i = 0; i < y; i++) {
			line = sc.next();
			for(int j = 0; j < x; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				now = arr[i][j];
				if(now != before && now != '|') {
					ans++;
				}
				before = now;
			}
			before = '.';
		}
		
		for(int j = 0; j < x; j++) {
			for(int i = 0; i < y; i++) {
				now = arr[i][j];
				if(now != before && now != '-') {
					ans++;
				}
				before = now;
			}
			before = '.';
		}
		
		System.out.println(ans);
	}
}
