import java.util.Scanner;

//수도 요금 경쟁
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int[] arr = new int[5];
			for(int j = 0; j < 5; j++) {
				arr[j] = sc.nextInt();
			}
			int payA = arr[4] * arr[0];
			int payB = arr[1];
			if(arr[4] > arr[2]) {
				payB += (arr[4]-arr[2]) * arr[3];
			}
			if(payA > payB)
				System.out.println("#" + (i+1) + " " + payB);
			else
				System.out.println("#" + (i+1) + " " + payA);
		}
	}
}
