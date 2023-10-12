import java.util.Arrays;
import java.util.Scanner;

//햄버거 분배
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int ans = 0;
		
		char[] arr = new char[N];
		String tmp = sc.next();
		
		for(int i = 0; i < N; i++)
			arr[i] = tmp.charAt(i);
		
		for(int i = 0; i < N; i++) {
			if(arr[i] != 'H')
				continue;
			for(int j = i-K; j <= i+K; j++) {
				if(j < 0 || j >= N || j == i)
					continue;
				if(arr[j] == 'P') {
					arr[i] = 'O';
					arr[j] = 'X';
					ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}
}
