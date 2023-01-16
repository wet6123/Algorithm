import java.util.Arrays;
import java.util.Scanner;

//십자카드 문제
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = 0;
		for (int tc = 0; tc < 4; tc++) {
			number = number * 10 + sc.nextInt();
		}

		int num = sort(number);
		int cnt = 1;
		int init = 1111;
		while (num > init) {
			init++;
			int sorted = sort(init);
			if (sorted < init) {
				cnt--;
			}
			cnt++;
		}
		System.out.println(cnt);
	}

	public static int sort(int number) {
		int[] arr = new int[4];
		for (int i = 3; i >= 0; i--) {
			arr[i] = number % 10;
			number /= 10;
		}

		int min = 10000;
		int ans = 0;
		for (int num = 0; num < 4; num++) {
			int ten = 1;
			ans = 0;
			for (int dis = 0; dis < 4; dis++) {
				int now = num + dis;
				if (now >= 4)
					now -= 4;
				ans =  ans * 10 + arr[now]; 
			}
			if (min > ans)
				min = ans;
		}
		return min;
	}
}
