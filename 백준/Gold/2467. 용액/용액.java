import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = N - 1;
        int min = Integer.MAX_VALUE;
        int num_1 = 0, num_2 = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                num_1 = arr[start];
                num_2 = arr[end];
            }

            if (sum > 0) {
                end--;
            } else if (sum < 0) {
                start++;
            } else {
                break;
            }
        }

        bw.write(num_1 + " " + num_2);
        bw.close();
    }
}