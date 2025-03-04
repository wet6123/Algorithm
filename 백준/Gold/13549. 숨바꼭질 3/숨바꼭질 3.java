import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new LinkedList<>();
        dq.add(N);
        int[] count = new int[100001];
        for(int i = 0; i <= 100000; i++) count[i] = (int)1e9 + 7;
        count[N] = 0;

        while(!dq.isEmpty()) {
            int num = dq.pollFirst();

            if(num * 2 <= 100000 && count[num * 2] > count[num]) {
                dq.addFirst(num * 2);
                count[num * 2] = count[num];
            }
            if (num + 1 <= 100000 && count[num + 1] > count[num] + 1) {
                dq.addLast(num + 1);
                count[num + 1] = count[num] + 1;
            }
            if (num - 1 >= 0 && count[num - 1] > count[num] + 1) {
                dq.addLast(num - 1);
                count[num - 1] = count[num] + 1;
            }
        }

        bw.write(count[K] + "");
        bw.close();
    }
}