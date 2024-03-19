import java.util.Arrays;
import java.util.Scanner;

//힙 배열로 구현
public class Solution {
	static int[] arr; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(tc+1);
			sb.append(" ");
			
			int N = sc.nextInt();
			arr = new int[N];
			int length = 0;
			for(int n = 0; n < N; n++) {
				int order = sc.nextInt();
				if (order == 1) {
					arr[++length] = sc.nextInt();
					sort(arr, length);
					
				} else {
					if(length == 0)
						sb.append(-1 + " ");
					else {
						sb.append(arr[1] + " ");
						arr[1] = arr[length];
						arr[length] = 0; //삭제할것
						sortDel(arr, 1, --length);
					}
					
				}
			}
			System.out.println(sb);
		}
	}
	public static void sort(int[] arr, int place) {
		if(place == 1 || arr[place/2] >= arr[place]) {
			return;
		}
		
		if(arr[place/2] < arr[place]) {
			int temp = arr[place/2];
			arr[place/2] = arr[place];
			arr[place] = temp;
			sort(arr, place/2);
		}
	}
	public static void sortDel(int[] arr, int place, int length) {
		if(place*2 > length || arr[place*2] <= arr[place]) {
			if(place*2+1 > length || arr[place*2+1] <= arr[place]) {
				return;
			}
		}
		
		int p;
		if(arr[place*2] > arr[place*2+1]) {			
			p = place*2;
		}
		else {		
			p = place*2 + 1;
		}
		if(arr[p] > arr[place]) {
			int temp = arr[p];
			arr[p] = arr[place];
			arr[place] = temp;
			sortDel(arr, p, length);
		}
	}
}
