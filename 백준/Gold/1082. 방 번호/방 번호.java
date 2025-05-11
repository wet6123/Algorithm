import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] prices = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());

        int minNum = 0;
        int minPrice = prices[0];
        
        for (int i = 1; i < N; i++) {
            if (prices[i] <= minPrice) {
                minNum = i;
                minPrice = prices[i];
            }
        }

        int maxLen = M / minPrice;

        int[] ans = new int[maxLen];
        Arrays.fill(ans, minNum);
        M -= (minPrice * maxLen);

        if (minNum == 0 && maxLen > 1) {
            all: for (int i = 0; i < maxLen; i++) {
                for (int j = 1; j < N; j++) {
                    if (M >= prices[j] - prices[0]) {
                        break all;
                    }
                }
                
                ans[i] = -1;
                M += prices[0];
            }
        }

        for (int idx = 0; idx < maxLen; idx++) {
            if (ans[idx] == -1) continue;
            int targetNum = minNum;
            int targetPrice = 0;

            for (int i = 0; i < N; i++) {
                if (M >= prices[i] - minPrice) {
                    targetNum = i;
                    targetPrice = prices[i] - minPrice;
                }
            }

            ans[idx] = targetNum;
            M -= targetPrice;
        }

        StringBuilder sb = new StringBuilder();
        if (ans[maxLen - 1] == -1) sb.append(0);
        else {
            for (int num : ans) {
                if (num == -1) continue;
                sb.append(num);
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
