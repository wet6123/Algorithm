import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
        int ans1 = (A + B) % C;
        int ans2 = ((A % C) + (B % C)) % C;
        int ans3 = (A * B) % C;
        int ans4 = ((A % C) * (B % C)) % C;
        
		bw.write(ans1 + "\n");
        bw.write(ans2 + "\n");
        bw.write(ans3 + "\n");
        bw.write(ans4 + "\n");
		bw.close();
	}
}
