import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//섬의 개수
public class Main {
	static int[][] arr;
	static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1};
	static int W;
	static int H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W + H == 0)
				break;

			arr = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (arr[i][j] != 0) {
						island(i, j);
						ans++;
					}
				}
			}

			System.out.println(ans);
		}
	}

	static void island(int i, int j) {
		if (arr[i][j] == 0)
			return;

		arr[i][j] = 0;
		for (int c = 0; c < 8; c++) {
			int x = j + dx[c];
			int y = i + dy[c];

			if (x < 0 || y < 0 || x >= W || y >= H)
				continue;
			island(y, x);
		}
	}
}
