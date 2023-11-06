import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String num = st.nextToken();
        int len = num.length();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) {
            nums[i] = num.charAt(i) - '0';
        }
        
        int idx = 0;
        int N = 0;
        while(idx < len) {
            N++;
            int tmp_N = N;
            int N_len = (int)(Math.log10(N) + 1);
            int[] N_arr = new int[N_len];
            for(int i = N_len - 1; i >= 0; i--) {
                N_arr[i] = tmp_N % 10;
                tmp_N /= 10;
            }
            for(int i = 0; i < N_len; i++) {
            	if(nums[idx] == N_arr[i])
            		idx++;
            	if(idx >= len)
            		break;
            }
        }
        bw.write(N + "");
        bw.close();
    }
}