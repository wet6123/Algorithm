import java.util.Arrays;
import java.util.Scanner;

// 치킨 TOP N
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		
		int member = sc.nextInt();
		
		int groupNum = num / member;
		int[] group = new int[groupNum];
		
		int cnt = 0;
		
		for(int j = 0; j < member; j++) {
			for(int i = 0; i < groupNum; i++) {
				group[i] = arr[cnt++];
			}
			Arrays.sort(group);
			for(int k = 0; k < groupNum; k++) {
				System.out.print(group[k] + " ");
			}
		}
	}
}
