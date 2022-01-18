package java;

import java.util.Scanner;

public class 백준1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int Fnum = -1;
		int cnt = 0;
		while(Fnum != num) {
			if(cnt == 0)
				Fnum = num;
			int newNum = Fnum/10 + Fnum%10;
			Fnum = (Fnum%10)*10 + newNum%10;
			cnt++;
		}
		System.out.println(cnt);
	}
}