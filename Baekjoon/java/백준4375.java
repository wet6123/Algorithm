package java;

import java.util.Scanner;

public class 백준4375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int num = sc.nextInt();
			long min = 1;
			int cnt = 1;
			while(min%num != 0) {
				if(num == 1)
					break;
				min = (min*10+1)%num;
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
