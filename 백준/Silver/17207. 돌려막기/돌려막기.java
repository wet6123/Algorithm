import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] arr1 = new int[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] arr2 = new int[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					sum += arr1[i][k] * arr2[k][j];
				}
			}
			if (min >= sum) {
				min = sum;
				idx = i;
			}
		}

		String[] names = { "Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki" };

		bw.write(names[idx]);
		bw.close();
	}
}
