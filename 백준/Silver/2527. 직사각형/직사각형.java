import java.util.Scanner;

//직사각형
public class Main {
	static int flagX;
	static int flagY;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 4; i++) {
			int[] arrA = new int[4];
			int[] arrB = new int[4];
			
			for(int j = 0; j < 4; j++) {
				arrA[j] = sc.nextInt();
			}
			for(int j = 0; j < 4; j++) {
				arrB[j] = sc.nextInt();
			}
			flagX = checker(arrA[0], arrA[2], arrB[0], arrB[2]);
			flagY = checker(arrA[1], arrA[3], arrB[1], arrB[3]);
			
			char ans = '-';
			int check = flagX * flagY;
			if(check == 0) {
				ans = 'd';
			} else if(check == 1) {
				ans = 'a';
			} else if(check == 2) {
				ans = 'b';
			} else if(check == 4){
				ans = 'c';
			}
			System.out.println(ans);
		}
	}
	
	public static int checker (int a, int b, int A, int B) {
		int ans;//0겹치지 않음, 1사이에 있음, 2 만남
		if(a == A || b == B) {
			ans = 1;
		}
		else if(a < A && b > A) {
			ans = 1;
		}
		else if( a < B && b > B) {
			ans = 1;
		}
		else if(A < a && B > a) {
			ans = 1;
		}
		else if( A < b && B > b) {
			ans = 1;
		}
		else if( a == B || b == A) {
			ans = 2;
		} else {
			ans = 0;
		}
		return ans;
	}
}
