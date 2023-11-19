import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//개미
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");

		int w = Integer.parseInt(input1[0]);
		int h = Integer.parseInt(input1[1]);
		int p = Integer.parseInt(input2[0]);
		int q = Integer.parseInt(input2[1]);
		int T = Integer.parseInt(br.readLine());

		int t = T;
		if (w - p < t) {
			t -= (w - p);
			p = w;
		}
		if ((t / w) % 2 == 1) {
			p = 0;
		}
		if (p == 0 || p < w)
			p += t % w;
		else
			p -= t % w;

		t = T;
		if (h - q < t) {
			t -= (h - q);
			q = h;
		}
		if ((t / h) % 2 == 1) {
			q = 0;
		}
		if (q == 0 || q < h)
			q += t % h;
		else
			q -= t % h;

		System.out.println(p + " " + q);
	}
}
