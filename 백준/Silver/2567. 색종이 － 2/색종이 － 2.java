import java.util.Scanner;

//색종이-2
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] arr = new boolean[101][101];
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					arr[x+j][y+k] = true;
				}
			}			
		}
		int cnt = 0;
		for(int j = 1; j <= 100; j++) {
			for(int k = 1; k <= 100; k++) {
				if(arr[j][k] != arr[j][k-1])
					cnt++;
				if(arr[k][j] != arr[k-1][j])
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
