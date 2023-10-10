import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        if(N > 0)
            st = new StringTokenizer(br.readLine());
        
        int cnt = 0;
        int sameCnt = 0;
        for(int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp > score) {
                cnt++;
            } else if(tmp == score) {
                sameCnt++;
            } else {
                break;
            }
        }
        
        if(cnt + sameCnt < P) {
            bw.write((cnt + 1) + "");
        } else {
            bw.write("-1");
        }
        bw.close();
    }
}