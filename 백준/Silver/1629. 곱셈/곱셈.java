import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static int C;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		bw.write(pow(A, B) + "");
		bw.close();
	}
	public static long pow(int A, int B) {
		if (B == 1) {
			return A % C;
		}
		
		long ans = pow(A, B / 2);
		
		if (B % 2 == 1) {
			return (ans * ans % C) * A % C;
		}
		
		return ans * ans % C;
	}
}
