import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// [S/W 문제해결 기본] 7일차 - 암호생성기
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			int T = sc.nextInt();
			int[] arr = new int[8];
			for(int j = 0; j < 8; j++) {
				arr[j] = sc.nextInt();
			}
			
			int idx = 0;
			int cnt = 1;
			while(true) {
				arr[idx] -= cnt;
				if(arr[idx] <= 0) {
					arr[idx] = 0;
					break;
				}
				idx++;
				cnt++;
				idx %= 8;
				if(cnt > 5)
					cnt = 1;
			}
				
			
			StringBuilder sb = new StringBuilder();
			for(int j = idx + 1; j < 8; j++) {
				sb.append(arr[j] + " ");
			}
			for(int j = 0; j < idx + 1; j++) {
				sb.append(arr[j] + " ");
			}
			System.out.println("#" + T + " " + sb);
		}
	}
}
