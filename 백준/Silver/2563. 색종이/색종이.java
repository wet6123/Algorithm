import java.util.Scanner;

//색종이
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		boolean[][] arr = new boolean[100][100];
		int cnt = 0;
		for(int i = 0; i < num; i++) {
			int x, y;
			x = sc.nextInt();
			y = sc.nextInt();
			
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					arr[x+j][y+k] = true;
				}
			}
			
		}
		for(int j = 1; j < 100; j++) {
			for(int k = 1; k < 100; k++) {
				if(arr[j][k] == true)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
