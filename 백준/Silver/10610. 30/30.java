import java.util.Arrays;
import java.util.Scanner;

//30
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		
		boolean flag = false;
		int sum = 0;
		int size = N.length();
		char[] arr = new char[size];
		
		for(int i = 0; i < size; i++) {
			char num = N.charAt(i);
			if(num == '0') {
				flag = true;
			}
			sum += num - '0';
			arr[i] = (char) num;
		}
		if((sum%3) != 0) {
			flag = false;
		}
		if(flag) {
			StringBuilder sb = new StringBuilder();
			Arrays.sort(arr);
			for(int i = size-1; i >= 0; i--)
				sb.append(arr[i]);
			System.out.println(sb);
		}
		else {
			System.out.println(-1);
		}
	}
}
