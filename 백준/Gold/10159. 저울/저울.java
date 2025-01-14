import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            arr[i][i] = true;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken()) - 1;
            int num2 = Integer.parseInt(st.nextToken()) - 1;
            arr[num1][num2] = true;
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if (arr[i][k] && arr[k][j]) {
                        arr[i][j] = true;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            int cnt = N;
            for(int j = 0; j < N; j++) {
                if (arr[i][j] || arr[j][i]) {
                    cnt--;
                }
            }
            bw.write(cnt + "\n");
        }
        bw.close();
    }
}