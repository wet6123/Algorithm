import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int ans = 0;
        
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int len = (row + col) * 2;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] map = new int[N + 1];
        
        for(int i = 0; i <= N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int idx = 0;
            if (dir == 1)
            {
                idx = num;
            }
            else if (dir == 2)
            {
                idx = row + col + row - num;
            }
            else if (dir == 3)
            {
                idx = row + col + row + col - num;
            }
            else
            {
                idx = row + num;
            }
            map[i] = idx;
        }
        // sum distance
        for(int i = 0; i < N; i++)
        {
            if (map[N] > map[i])
            {
                int len_1 = map[N] - map[i];
                int len_2 = map[i] + (len - map[N]);
                ans += Math.min(len_1, len_2);
            }
            else if (map[N] < map[i])
            {
                int len_1 = map[i] - map[N];
                int len_2 = map[N] + (len - map[i]);
                ans += Math.min(len_1, len_2);
            }
        }
        
        bw.write(ans + "");
        bw.close();
    }
}