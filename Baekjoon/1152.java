package start01;

import java.util.Scanner;

public class 단어의개수 {
	public static void main(String[] args) {
		int spc = 0;
		Scanner sc = new Scanner(System.in);
		String s;
		s = sc.nextLine();
		if(s.charAt(0) == ' ')
			spc--;
		if(s.charAt(s.length()-1) == ' ')
			spc--;
		
		for(int i = 0; i < s.length(); i++) {
			char tmpchar = s.charAt(i);
			if('A' <= tmpchar && tmpchar <= 'Z' || 'a' <= tmpchar && tmpchar <= 'z') {}
			else if(tmpchar == ' ')
				spc++;
		}
		System.out.println(spc + 1);
	}
}
