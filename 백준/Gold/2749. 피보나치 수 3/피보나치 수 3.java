import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        bw.write(fibonacci(n) + "\n");
        bw.close();
    }
    public static matrix multi(matrix A, matrix B) {
        matrix result = new matrix();
        result.data[0][0] = (A.data[0][0] * B.data[0][0] + A.data[0][1] * B.data[1][0]) % 1000000;
        result.data[0][1] = (A.data[0][0] * B.data[0][1] + A.data[0][1] * B.data[1][1]) % 1000000;
        result.data[1][0] = (A.data[1][0] * B.data[0][0] + A.data[1][1] * B.data[1][0]) % 1000000;
        result.data[1][1] = (A.data[1][0] * B.data[0][1] + A.data[1][1] * B.data[1][1]) % 1000000;
        return result;
    }
    public static matrix pow(matrix A, long n) {
        matrix result = A;
        if (n > 1)
        {
            result = pow(A, n / 2);
            result = multi(result, result);
            if (n % 2 == 1)
                result = multi(result, new matrix());
        }
        return result;
    }
    public static long fibonacci(long n) {
        if (n == 0)
            return 0;
        matrix result = pow(new matrix(), n);
        return result.data[0][1];
    }
    static class matrix {
        long[][] data = new long[2][2];
        
        matrix() {
            data[0][0] = 0; data[0][1] = 1;
            data[1][0] = 1; data[1][1] = 1;
        }
    }
}