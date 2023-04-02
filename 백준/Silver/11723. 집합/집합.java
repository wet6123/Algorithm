import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int set = 0;
		int M = Integer.parseInt(st.nextToken());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int num;

			if (op.equals("add")) {
				num = Integer.parseInt(st.nextToken());
				set |= (1 << (num - 1));
			} else if (op.equals("remove")) {
				num = Integer.parseInt(st.nextToken());
				set &= ~(1 << (num - 1));
			} else if (op.equals("check")) {
				num = Integer.parseInt(st.nextToken());
				int re;
				if ((set & (1 << (num - 1))) == (1 << (num - 1))) {
					re = 1;
				} else {
					re = 0;
				}
				bw.write(re + "\n");
			} else if(op.equals("toggle")) {
				num = Integer.parseInt(st.nextToken());
				set ^= (1 << (num - 1));
			} else if(op.equals("all")) {
				set |= (~0);
			} else if(op.equals("empty")) {
				set &= 0;
			}
		}
		bw.close();
	}
}
