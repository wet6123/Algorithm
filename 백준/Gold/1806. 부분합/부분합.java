import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int[] nums;
        int N, S;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        nums = new int[N];
        for (int i = 0; i < N; i++)
        {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = N + 1;
        int sum = nums[0];
        int low = 0;
        int high = 0;
        
        while(low <= high && high < N)
        {
            if (sum < S)
            {
                high++;
                if (high >= N)
                    break;
                sum += nums[high];
            }
            else
            {
                ans = Math.min(ans, high - low + 1);
                sum -= nums[low];
                low++;
            }
        }

        if (ans == N + 1)
            ans = 0;
        bw.write(ans + "");
        bw.close();
    }
}
