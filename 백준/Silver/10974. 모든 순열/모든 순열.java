import java.util.ArrayList;
import java.util.Scanner;

//모든 순열
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < num; i++) {
			list.add(i+1);
		}
		int[] arr = new int[num];
		printIt(list, arr, 0);
		
	}
	public static void printIt(ArrayList<Integer> list, int[] arr, int cnt) {
		if (list.isEmpty()) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		int length = list.size();
		
		for(int i = 0; i < length; i++) {
			ArrayList<Integer> listNew = new ArrayList<>();
			listNew.addAll(list);
			arr[cnt] = list.get(i);
			listNew.remove(i);
			printIt(listNew, arr, cnt+1);
		}
	}
}
