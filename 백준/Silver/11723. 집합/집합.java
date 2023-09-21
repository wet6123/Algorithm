import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int set = 0;
        int M = Integer.parseInt(st.nextToken());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num;
            
            if (op.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                set |= (1 << (num - 1));
            } else if (op.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                set &= ~(1 << (num - 1));
            } else if (op.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                if ((set & (1 << (num - 1))) == (1 << (num - 1)))
                    bw.write("1\n");
                else
                    bw.write("0\n");
            } else if (op.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                set ^= (1 << (num - 1));
            } else if (op.equals("all")) {
                set |= (~0);
            } else if (op.equals("empty")) {
                set &= 0;
            }
        }
        bw.close();
    }
}