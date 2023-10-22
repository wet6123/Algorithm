import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ans = Integer.parseInt(st.nextToken());
        int before = ans;
        
        for(int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
            int tmp = (now - before + 1) / 2;
            if(tmp > ans)
                ans = tmp;
            before = now;
        }
        int last = N - before;
        if(last > ans)
            ans = last;
        bw.write(ans + "\n");
        bw.close();
    }
}