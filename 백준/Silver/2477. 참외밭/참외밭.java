import java.util.Scanner;

//참외밭
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();// 참외의 수

		int xMax = 0;// 동, 서 이동중 가장 큰 값
		int xidx = 0;// 가장 큰 값일 때 인덱스
		int yMax = 0;// 북, 남 이동중 가장 큰 값
		int yidx = 0;// 가장 큰 값일 때 인덱스
		int[] arr = new int[6];
		for (int i = 0; i < 6; i++) {
			int dirction = sc.nextInt();
			arr[i] = sc.nextInt();
			if (dirction == 1 || dirction == 2) {// 동, 서 이동일 경우
				if (xMax < arr[i]) {
					xMax = arr[i];
					xidx = i;
				}
			} else {// 북, 남 이동일 경우
				if (yMax < arr[i]) {
					yMax = arr[i];
					yidx = i;
				}

			}
		}
		int idx;
		int idxNext;
		// 가로 세로에서 각각 가장 긴 두변은 항상 연속하거나 마지막과 처음이다.
		// 그렇다면 큰 네모에서 빼야하는 작은 네모의 두변의 길이는
		// 긴 두변의 인덱스 중 뒤쪽 인덱스에 다음 다음에 하나가 있고 그다음에 하나가 있다.
		// 네모를 그려보면 이해하기 쉽다.
		if (Math.abs(xidx - yidx) > 1) {// 0번과 5번 인덱스가 가장 큰 2변인 경우
			idx = 2;
		} else {// 이외의 연속된 경우
			idx = (xidx > yidx) ? xidx : yidx;
			idx += 2;
			if (idx > 5) {
				idx -= 6;
			}
		}
		idxNext = idx + 1;
		if (idxNext > 5)
			idxNext -= 6;

		int ans = num * (xMax * yMax - arr[idx] * arr[idxNext]);
		System.out.println(ans);
	}
}
