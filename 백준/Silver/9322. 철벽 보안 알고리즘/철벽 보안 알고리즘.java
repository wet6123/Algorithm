import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> map = new HashMap<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				map.put(st.nextToken(), i);
			}
			
			st = new StringTokenizer(br.readLine());
			int[] ansIdx = new int[N];
			for (int i = 0; i < N; i++) {
				ansIdx[i] = map.get(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			String[] ans = new String[N];
			for (int i = 0; i < N; i++) {
				ans[ansIdx[i]] = st.nextToken();
			}
			
			for (int i = 0; i < N; i++) {
				bw.write(ans[i] + " ");
			}
			bw.write("\n");
		}
		bw.close();
	}
}
