import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//트리의 부모 찾기
public class Main {

	static int T;
	static ArrayList<Integer>[] arr;
	static int[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		arr = new ArrayList[T + 1];
		for (int i = 1; i <= T; i++)
			arr[i] = new ArrayList();
		for (int i = 1; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int F = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			arr[F].add(B);
			arr[B].add(F);
		}

		ans = new int[T + 1];

		makeAns(1, 1);

		for(int i = 2; i < ans.length; i++)
			System.out.println(ans[i]);
	}

	public static void makeAns(int idx, int parents) {
		int size = arr[idx].size();
		if(size == 0)
			return;
		
		for (int i = 0; i < size; i++) {
			int num = arr[idx].remove(0);
			if (num != parents) {
				ans[num] = idx;
				makeAns(num, idx);
			}
		}
	}
}
