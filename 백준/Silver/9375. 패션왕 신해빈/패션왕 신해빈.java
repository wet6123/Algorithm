import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//패션왕 신해빈

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			
			List<String> list = new ArrayList<String>();
			int cnt = -1;
			int[] clothCnt = new int[N];
			
			for (int n = 0; n < N; n++) {
				String cloth = sc.next();
				String part = sc.next();
				
				if(!list.contains(part)) {//새로운 부위에 착용하는 의상이면 종류 늘려줌
					cnt++;
					clothCnt[cnt]++;
					list.add(part);
				}
				clothCnt[list.indexOf(part)]++;
			}
			int ans = 1;
			for(int n = 0; n < N; n++) {
				if(clothCnt[n] == 0) {
					break;					
				}
				ans *= clothCnt[n];
			}
			ans--;
			System.out.println(ans);
		}
	}
}
