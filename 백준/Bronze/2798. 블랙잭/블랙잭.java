import java.util.Scanner;

//블랙잭
public class Main {
	static int[] cards;
	static int cardNum;
	static int num;
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		cardNum = sc.nextInt();
		num = sc.nextInt();
		cards = new int[cardNum];
		
		for(int i = 0; i < cardNum; i++) {
			cards[i] = sc.nextInt();
		}
		
		max = 0;
		rec(0, 0, 0);
		
		System.out.println(max);
	}
	public static void rec(int cnt, int idx, int sum) {
		if(sum > num)
			return;
		if(cnt >= 3) {
			max = Math.max(max, sum);
			return;
		}
		if(idx >= cardNum)
			return;
		
		rec(cnt, idx+1, sum);		
		rec(cnt+1, idx+1, sum+cards[idx]);		
	}
}
