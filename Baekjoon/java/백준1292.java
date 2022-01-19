import java.util.Scanner;

public class 백준1292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		int index = 0;
		int sum = 0;
		for(int i=1; i<=45; i++) {
			for(int j = 0; j<i;j++) {
				index++;
				if(index>=a && index<=b) {
					sum+=i;
				}
				if(index>b)break;
			}
			if(index>b)break;
		}
		System.out.println(sum);
	}
}
