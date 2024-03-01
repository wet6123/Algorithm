import java.util.Scanner;

//가랏! RC카!
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int cmdNum = sc.nextInt();
			int acc = 0;
			int currentVel = 0;
			int distance = 0;
			for(int j = 0; j<cmdNum; j++) {
				int cmd = sc.nextInt();
				if(cmd == 1 || cmd == 2) {
					acc = sc.nextInt();
				}
				
				switch (cmd) {
				case 0:
					distance += currentVel;
					break;
				case 1:
					currentVel += acc;
					distance += currentVel;
					break;
				case 2:
					currentVel -= acc;
					if(currentVel < 0)currentVel=0;
					distance += currentVel;
					break;
				default:
					break;
				}
			}
			System.out.printf("#%d %d\n", i+1, distance);
		}
	}
}
