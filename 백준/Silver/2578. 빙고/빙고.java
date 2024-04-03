import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        int[][] map = new int[5][5];
        int[][] marked = new int[5][5];
        
        for(int i = 0; i < 5; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean bingo = false;
        int ans = 0;
        int idx = 5;
        
        while (!bingo)
        {
            if (idx == 5)
            {
                idx = 0;
                st = new StringTokenizer(br.readLine());
            }
            idx++;
            
            // 1 mark number
            int num = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    if (map[i][j] == num)
                    {
                        marked[i][j] = 1;
                        ans++;
                    }
                }
            }
            // 2 check bingo
            int bingo_cnt = 0;
            int cross_1 = 0;
            int cross_2 = 0;
            for(int i = 0; i < 5; i++)
            {
                int col = 0;
                int row = 0;
                for(int j = 0; j < 5; j++)
                {
                    // col
                    if (marked[j][i] == 1)
                        col++;
                    // row
                    if (marked[i][j] == 1)
                        row++;
                }
                // cross
                if (marked[i][i] == 1)
                    cross_1++;
                if (marked[i][4 - i] == 1)
                    cross_2++;
                // check_col_row_bingo
                if (col == 5)
                    bingo_cnt++;
                if (row == 5)
                    bingo_cnt++;
            }
            // check_cross_bingo
            if (cross_1 == 5)
                bingo_cnt++;
            if (cross_2 == 5)
                bingo_cnt++;
            if (bingo_cnt >= 3)
                bingo = true;
        }
        // print
        bw.write(ans + "");
        bw.close();
    }
}