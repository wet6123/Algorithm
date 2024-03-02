import java.util.Scanner;

//쉬운 거스름돈
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int won = sc.nextInt();
			System.out.println("#"+(i+1));
			System.out.print(won/50000 + " ");
			System.out.print((won%=50000)/10000 + " ");
			System.out.print((won%=10000)/5000 + " ");
			System.out.print((won%=5000)/1000 + " ");
			System.out.print((won%=1000)/500 + " ");
			System.out.print((won%=500)/100 + " ");
			System.out.print((won%=100)/50 + " ");
			System.out.print((won%=50)/10 + "\n");
		}
	}
}