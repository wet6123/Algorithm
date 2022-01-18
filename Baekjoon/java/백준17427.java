package java;

import java.util.Scanner;

public class 백준17427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		long sum = 1;
//		for(int i = 2; i <= num; i++) {
//			int tmp = i;
//			int tmpTotal = 1;
//			for(int j = 2; j <= i; j++) {
//				int tmpSum = 1;
//				while(tmp%j == 0) {
//					tmp = tmp/j;
//					tmpSum = tmpSum*j + 1;
//				}
//				tmpTotal = tmpTotal*tmpSum;
//			}
//			sum += tmpTotal;
//		}
//		System.out.println(sum);
		int num = sc.nextInt();
		long sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += (num/i)*i;
		}
			System.out.println(sum);
	}
}
