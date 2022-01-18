import java.util.Scanner;

public class 코드업1271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			if(max < num)
				max = num;
		}
		System.out.println(max);
	}
}
