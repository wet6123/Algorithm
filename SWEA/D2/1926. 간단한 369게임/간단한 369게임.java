import java.util.Scanner;

//간단한 369게임
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			int num = i;
			boolean flag = true;
			flag = test(num, flag);
			if(flag)System.out.print(num);
			System.out.print(" ");
		}
	}
	public static boolean test(int num, boolean flag) {
		while(num > 10) {
			if((num%10)%3 == 0 && num%10 > 0) {
				System.out.print("-");
				flag = false;
			}
			num/=10;
		}
		if(num%3 == 0) {
			System.out.print("-");
			flag = false;
		}
		return flag;
	}
}
