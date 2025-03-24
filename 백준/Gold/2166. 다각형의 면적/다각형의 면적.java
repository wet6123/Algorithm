import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];


        long front = 0, back = 0;
        for(int i = 0; i < N; i++) {
            front += (long)arr[i][0] * arr[i + 1][1];
            back += (long)arr[i][1] * arr[i + 1][0];
        }

        double ans = 0.5 * Math.abs(front - back);
        bw.write(String.format("%.1f", ans));
        bw.close();
    }
}