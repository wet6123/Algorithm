import java.util.Scanner;

//규영이와 인영이의 카드게임_합가지고 가기
public class Solution {
	static int win;
	static int lose;
	static int[] cardG;
	static boolean[] cardI;
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			win = 0;
			lose = 0;

			result = new int[9];
			cardG = new int[9];
			cardI = new boolean[19];

			for (int line = 0; line < 9; line++) {
				int num = sc.nextInt();
				cardG[line] = num;
				cardI[num] = true;
			}

			perm(0, 0, 0);
			System.out.println("#" + (tc + 1) + " " + win + " " + lose);
		}
	}

	static void perm(int idx, int gScore, int iScore) {
		if(gScore > 86) {
                int ans = 1;
            for(int i = 1; i <= 9-idx; i++){
            	ans *= i;
            }
			win+=ans;
			return;
		}
		if(iScore > 86) {
            int ans = 1;
            for(int i = 1; i <= 9-idx; i++){
            	ans *= i;
            }
			lose+=ans;
			return;
		}
		if(idx == 9) {
			if(gScore > iScore)
				win++;
			else if(gScore < iScore)
				lose++;
			return;
		}
		
		for(int i = 1; i < 19; i++) {
			if(cardI[i])
				continue;
			
			cardI[i] = true;
			
			if(cardG[idx] > i)
				perm(idx+1, gScore+cardG[idx]+i, iScore);
			else if(cardG[idx] < i)
				perm(idx+1, gScore, iScore+cardG[idx]+i);
			
			cardI[i] = false;
		}
	}

}
