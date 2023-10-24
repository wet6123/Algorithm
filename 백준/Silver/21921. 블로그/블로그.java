import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }
        
        int num = N - X + 1;
        int max = arr[X - 1];
        int cnt = 1;
        for(int i = X; i < N; i++) {
            int sum = arr[i] - arr[i - X];
            if(max < sum) {
                max = sum;
                cnt = 1;
            }else if(max == sum) {
                cnt++;
            }
        }
        
        if(max == 0)
            bw.write("SAD\n");
        else {
            bw.write(max + "\n");
            bw.write(cnt + "\n");
        }
        bw.close();
    }
}