import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] grade = new int[N];

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int num_1 = Integer.parseInt(st.nextToken());
                int num_2 = Integer.parseInt(st.nextToken());
                grade[num_1 - 1] = num_2;
            }

            int ans = 0;
            int max = N + 1;
            for (int i = 0; i < N; i++) {
                if (grade[i] < max) {
                    max = grade[i];
                    ans++;
                }
            }
            bw.write(ans + "\n");
        }
        bw.close();
    }
}