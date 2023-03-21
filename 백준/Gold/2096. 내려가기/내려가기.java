import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//내려가기
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] dpMax = new int[3];
		int[] dpMin = new int[3];
		int[] temp = new int[3];
		int[] arr = new int[3];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dpMin[i] = arr[i];
			dpMax[i] = arr[i];
		}

		for (int i = 1; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			arr[2] = Integer.parseInt(st.nextToken());
			
			temp[0] = Math.min(dpMin[0], dpMin[1]) + arr[0];
			temp[1] = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]) + arr[1];
			temp[2] = Math.min(dpMin[1], dpMin[2]) + arr[2];
			
			dpMin[0] = temp[0];
			dpMin[1] = temp[1];
			dpMin[2] = temp[2];

			temp[0] = Math.max(dpMax[0], dpMax[1]) + arr[0];
			temp[1] = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]) + arr[1];
			temp[2] = Math.max(dpMax[1], dpMax[2]) + arr[2];
			
			dpMax[0] = temp[0];
			dpMax[1] = temp[1];
			dpMax[2] = temp[2];
		}
		int min = Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]);
		int max = Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]);

		System.out.println(max + " " + min);
	}
}