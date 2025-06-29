import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());

        bw.write((int) (Math.pow(2, N) - 1) + "\n");

        Hanoi(N, 1, 2, 3);

        bw.close();
    }

    public static void Hanoi(int N, int start, int help, int end) throws IOException {
        if (N == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }

        Hanoi(N - 1, start, end, help);

        bw.write(start + " " + end + "\n");

        Hanoi(N - 1, help, start, end);
    }
}