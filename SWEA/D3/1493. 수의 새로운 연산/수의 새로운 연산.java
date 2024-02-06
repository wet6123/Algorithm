import java.util.Arrays;
import java.util.Scanner;

//수의 새로운 연산
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int[] resultP = find(p);
			int[] resultQ = find(q);
			

			
			int X = resultP[0] + resultQ[0];//결과의 좌표 구함
			int Y = resultP[1] + resultQ[1];
			
			int ans = 1;
			for(int i = 1; i < Y+X-1; i++) {
				ans += i;
			}
			ans += (X-1);
			
			System.out.println("#" + (tc+1) + " " + ans);
		}
	}
	public static int[] find (int num) {
		int cnt = 1;
		int idx = 1;
		//탐색하면서 num이 있는 라인의 첫 숫자 (1,N)위치의 숫자 찾는다.
		while(idx + cnt <= num) {
			idx+=cnt;
			cnt++;
		}
		
		//찾은 첫 숫자와 목표값 차이만큼 연산, x,y좌표 구한다.
		int X = 1+(num-idx);
		int Y = cnt-(num-idx);
		
		int[] result = new int[2];
		result[0] = X;
		result[1] = Y;
		
		return result;
	}
}
