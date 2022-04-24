import java.util.Scanner;

//숫자야구
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] input = new int[5][N];
		for(int n = 0; n < N; n++) {
			int num = sc.nextInt();
			input[0][n] = num % 10;
			input[1][n] = (num % 100) / 10;
			input[2][n] = num / 100;
			input[3][n] = sc.nextInt();
			input[4][n] = sc.nextInt();
		}
		int ans = 0;
		for(int i = 1; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				for(int k = 1; k < 10; k++) {
					int check = 0;
					
					if(i == j || i == k || k == j)
						continue;
					for(int n = 0; n < N; n++) {
						int strike = 0;
						int ball = 0;
						
						if(i == input[2][n]) 
							strike++;
						if(j == input[1][n]) 
							strike++;
						if(k == input[0][n]) 
							strike++;
						
							
						if(i == input[0][n] || i == input[1][n])
							ball++;
						if(j == input[0][n] || j == input[2][n])
							ball++;
						if(k == input[1][n] || k == input[2][n])
							ball++;
						
						if(strike == input[3][n] && ball == input[4][n])
							check++;
					}
					if(check == N)
						ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
