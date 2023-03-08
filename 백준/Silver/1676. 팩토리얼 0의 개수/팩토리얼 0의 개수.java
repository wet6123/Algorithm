import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int factorial = 1;
        int cntFive = 0;
        
        for (int i = 1; i <= num; i++) {
            int tmp = i;
            while (tmp > 0 && tmp % 5 == 0) {
            	tmp /= 5;
            	cntFive++;
            }
        }
        
        bw.write(cntFive + "");
        bw.close();
    }
}