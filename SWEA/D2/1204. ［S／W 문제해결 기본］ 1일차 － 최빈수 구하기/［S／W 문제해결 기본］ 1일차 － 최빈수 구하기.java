import java.util.Scanner;

// [S/W 문제해결 기본] 1일차 - 최빈수 구하기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int testNum = sc.nextInt();
			int[] score = new int[101];
			for (int j = 0; j < 1000; j++) {
				score[sc.nextInt()]++;
			}
			int max = 0;
			int idx = 0;
			for (int j = 1; j < 101; j++) {
				if (max <= score[j]) {
					max = score[j];
					idx = j;
				}
			}
			System.out.printf("#%d %d\n", testNum, idx);
		}
	}
}
