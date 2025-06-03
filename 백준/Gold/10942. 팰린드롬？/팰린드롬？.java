import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;
    static int[] nums;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        dp = new boolean[N][N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        palindrome();

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()) - 1;
            int E = Integer.parseInt(st.nextToken()) - 1;

            bw.write((dp[S][E] ? 1 : 0) + "\n");
        }

        bw.close();
    }

    static void palindrome() {
        // 1자리
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }
        
        // 2자리
        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = (nums[i] == nums[i + 1]);
        }
        
        // 3자리 이상
        for (int size = 2; size < N; size++) {
            for (int i = 0; i < N - size; i++) {
                dp[i][i + size] = (nums[i] == nums[i + size]) && dp[i + 1][i + size - 1];
            }
        }
    }
}