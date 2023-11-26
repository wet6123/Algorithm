import java.util.Arrays;
import java.util.Scanner;

//K번째 수
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[num];

		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr, 0, arr.length - 1);

		System.out.println(arr[K-1]);
	}

	public static void quickSort(int[] arr, int start, int end) {

		// quick sorting
		int startNum = start;
		int endNum = end;
		int pivot = arr[(start + end) / 2];

		while (start <= end) {
			while (pivot > arr[start]) {
				start++;
			}
			while (pivot < arr[end]) {
				end--;
			}
			if (start <= end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
				start++;
				end--;
			}
		}
		if (startNum < start - 1)
			quickSort(arr, startNum, start - 1);
		if (endNum > start)
			quickSort(arr, start, endNum);
	}
}
