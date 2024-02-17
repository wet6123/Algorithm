import java.util.Scanner;

//영준이의 카드 카운팅
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			int[] S = new int[14];
			int[] D = new int[14];
			int[] H = new int[14];
			int[] C = new int[14];
			
			boolean flag = true;
			String str = sc.next();
			int idx = 0;
			while(idx < str.length()) {
				int num = ((str.charAt(idx+1) - '0')*10 + (str.charAt(idx+2)- '0'));
				if(str.charAt(idx) == 'S') {
					S[num]++;
					if(S[num]>=2)flag=false;
				}
				else if(str.charAt(idx) == 'D') {
					D[num]++;
					if(D[num]>=2)flag=false;
				}
				else if(str.charAt(idx) == 'H') {
					H[num]++;
					if(H[num]>=2)flag=false;
				}
				else if(str.charAt(idx) == 'C') {
					C[num]++;
					if(C[num]>=2)flag=false;
				}
				idx+=3;
			}
			int cntS = 0;
			int cntD = 0;
			int cntH = 0;
			int cntC = 0;
			for(int i = 1; i < 14; i++) {
				if(S[i]==0)cntS++;
				if(D[i]==0)cntD++;
				if(H[i]==0)cntH++;
				if(C[i]==0)cntC++;
			}
			if(flag)
				System.out.println("#" + (tc+1) + " " + cntS + " " + cntD + " " + cntH + " " + cntC);
			else
				System.out.println("#" + (tc+1) + " ERROR");
		}
		
	}
}
