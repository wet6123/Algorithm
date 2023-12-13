import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String S = st.nextToken();
        int len = S.length();
        int[] cnt = new int[2];
        for(int i = 0; i < len; i++) {
        	if (S.charAt(i) == '0')
        		cnt[0]++;
        	else
        		cnt[1]++;
        }
        cnt[0] /= 2;
        cnt[1] /= 2;
        
        int[] del = new int[len];
        int i = len - 1;
        while (i >= 0) {
        	if (S.charAt(i) == '0') {
        		del[i] = 1;
        		cnt[0]--;
        	}
        	if (cnt[0] == 0)
        		break;
        	i--;
        }
        i = 0;
        while (i < len) {
        	if (S.charAt(i) == '1') {
        		del[i] = 1;
        		cnt[1]--;
        	}
        	if (cnt[1] == 0)
        		break;
        	i++;
        }
        i = 0;
        while (i < len) {
        	if (del[i] == 0)
        		bw.write(S.charAt(i) + "");
        	i++;
        }
        bw.close();
    }
}