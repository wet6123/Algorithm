import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//준홍이의 카드놀이
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N + M + 1];
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= M; k++) {
					arr[j + k]++;
				}
			}
			
			int max = 0;
			Stack<Integer> idx = new Stack();
			for (int j = M + N; j > 0; j--) {
				if (max < arr[j]) {
					max = arr[j];
					idx.clear();
					idx.push(j);
				} else if (max == arr[j]) {
					idx.push(j);
				}
			}
			
			System.out.print("#" + (i + 1));
			int leng = idx.size();
			for (int j = 0; j < leng; j++) {
				System.out.print(" " + idx.pop());
			}
			System.out.println();
		}
	}
}
