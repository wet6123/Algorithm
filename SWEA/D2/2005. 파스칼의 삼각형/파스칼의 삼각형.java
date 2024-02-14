import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//파스칼의 삼각형
public interface Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			List<Object> arrBefore = new ArrayList<Object>();
			List<Object> arr = new ArrayList<Object>();
			int N = sc.nextInt();
			int sum = 0;
			arrBefore.add(1);
			
			System.out.println("#" + (i+1));
			//1번째 케이스 수동 출력
			System.out.println(arrBefore.get(0));

			//2번째 이후 케이스
			for (int j = 1; j < N; j++) {
				for (int k = 0; k <= j; k++) {
					sum = 0;
					if (k - 1 >= 0) {
						sum += (int)arrBefore.get(k - 1);
					}
					if (k < j) {
						sum += (int)arrBefore.get(k);
					}
					arr.add(sum);
				}
				arr.forEach(item -> System.out.printf("%d ", item));
				System.out.println();
				arrBefore.clear();
				arr.forEach(item -> arrBefore.add(item));
				arr.clear();

			}
		}
	}
}
