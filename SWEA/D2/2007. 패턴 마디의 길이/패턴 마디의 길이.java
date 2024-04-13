import java.util.Scanner;

//패턴 마디의 길이
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		char[] arr = new char[10];
		for(int i = 0; i < T; i++) {
			String str = sc.next();
			int idx = 0;
			boolean flag = true;
			for(int j = 0; j < str.length(); j++) {
				flag = true;
				if(arr[0] == str.charAt(j)) {
					for(int k = 0; k < j; k++) {
						if(arr[k] != str.charAt(j+k)) {
							arr[j] = str.charAt(j);
							flag = false;
							break;
						}
					}
					if(flag) {						
						idx = j;
						break;
					}
				} else {					
					arr[j] = str.charAt(j);
				}
			}
			System.out.println("#" + (i+1) + " " + idx);
		}
	}
}
