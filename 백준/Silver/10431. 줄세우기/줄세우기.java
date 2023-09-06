import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int P = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < P; i++) {
            int sum = 0;
            
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            
            List<Integer> N = new ArrayList<Integer>();
            for (int j = 0; j < 20; j++) {
                N.add(Integer.parseInt(st.nextToken()));
            }
            
            for (int x = 0; x < 20; x++) {
            	for (int y = 0; y < x; y++) {
            		int num = N.get(x);
            		if (N.get(y) > num)
            			sum++;
            	}
            }
            
            bw.write(T + " " + sum + "\n");
        }
        bw.close();
    }
}