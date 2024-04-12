import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[1000001];
        int[] idx = new int[10];
        int N = 0;
        int val = 0;
        int tmp, len, num, i;
        boolean flag;
        
        while (N < 1000001)
        {
            flag = true;
            //check
            for(i = 0; i < 10; i++)
                idx[i] = 0;
            tmp = val;
            len = (int)Math.log10(tmp) + 1;
            while (len > 0)
            {
                if (idx[tmp % 10] > 0)
                {
                    flag = false;
                    break;
                }
                idx[tmp % 10]++;
                tmp /= 10;
                len--;
            }
            
            if (flag)
            {
                arr[N] = val;
                N++;
            }
            val++;
        }

        while (true)
        {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            if (num == 0)
                break;
            bw.write(arr[num] + "\n");
        }
        bw.close();
    }
}
        