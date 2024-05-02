import java.util.Scanner;

//영화감독 숌
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int init = 666;
		int N = sc.nextInt();
		int num = 1;
		while(num < N) {
			init++;
			int tmp = init;
			int cnt = 0;
			while(tmp > 0) {
				if(tmp % 10 == 6) {
					cnt++;
				} else {
					cnt = 0;
				}
				tmp = tmp / 10;
				if(cnt == 3) {
					num++;
					break;
				}
			}
		}
		System.out.println(init);
	}
}
