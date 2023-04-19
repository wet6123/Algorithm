import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		BigInteger up = BigInteger.ONE;
		BigInteger down = BigInteger.ONE;
		
		for (int i = 0; i < M; i++) {
			up = up.multiply(new BigInteger(String.valueOf(N - i)));
			down = down.multiply(new BigInteger(String.valueOf(M - i)));
		}
		
		BigInteger ans = up.divide(down);
		bw.write(ans + "");
		bw.close();
	}
}
