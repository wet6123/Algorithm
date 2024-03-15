import java.util.Arrays;
import java.util.Scanner;

//중위순회
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int n = 0; n < 10; n++) {
			int T = sc.nextInt();
			char[] arr = new char[T+1];
			
			for(int tc = 1; tc <= T; tc++) {
				sc.nextInt();
				arr[tc] = sc.nextLine().charAt(1);
			}
			System.out.print("#" + (n+1) + " ");
			inorder(arr, 1, T);
			System.out.println();
		}
	}
	
	public static void inorder(char[] arr, int idx, int size) {
		if(idx > size)
			return;
		
		inorder(arr, idx*2, size);
		System.out.print(arr[idx]);
		inorder(arr, idx*2+1, size);
	}
}
