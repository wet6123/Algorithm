import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] map = new int[W];
        for(int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];
        int max = 0;
        for(int i = 0; i < W; i++) {
            max = Math.max(max, map[i]);
            leftMax[i] = max;
        }

        max = 0;
        for(int i = W - 1; i >= 0; i--) {
            max = Math.max(max, map[i]);
            rightMax[i] = max;
        }

        int ans = 0;

        for(int i = 1; i < W - 1; i++) {
            int now = Math.min(leftMax[i], rightMax[i]) - map[i];
            if (now > 0) ans += now;
        }
        bw.write(ans + "");
        bw.close();
    }
}