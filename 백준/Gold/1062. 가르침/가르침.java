import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }
        
        if (K < 5) {
            bw.write(0 + "");
            bw.close();
            return;
        }
        
        int[] wordNeed = new int[N];
        
        for (int i = 0; i < N; i++) {
            String word = words[i];
            for (int j = 4; j < word.length() - 4; j++) {
                char c = word.charAt(j);
                if (c != 'a' && c != 'n' && c != 't' && c != 'i' && c != 'c') {
                    wordNeed[i] |= (1 << (c - 'a'));
                }
            }
        }
        
        int answer = 0;
        
        int essentialMask = (1 << ('a' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a')) | (1 << ('i' - 'a')) | (1 << ('c' - 'a'));
        for (int mask = 0; mask < (1 << 26); mask++) {
            if ((mask & essentialMask) != essentialMask) {
                continue;
            }
            
            if (Integer.bitCount(mask) != K) {
                continue;
            }
            
            int count = 0;
            for (int i = 0; i < N; i++) {
                if ((wordNeed[i] & mask) == wordNeed[i]) {
                    count++;
                }
            }
            
            answer = Math.max(answer, count);
        }

        bw.write(answer + "");
        bw.close();
    }
}
