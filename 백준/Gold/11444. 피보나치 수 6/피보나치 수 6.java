import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());

        bw.write(fibonacci(n) + "");
        bw.close();
    }

    public static long[][] multiplyMatrix(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        
        C[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        C[0][0] %= (long)(1e9 + 7);
        C[0][1] %= (long)(1e9 + 7);
        C[1][0] %= (long)(1e9 + 7);
        C[1][1] %= (long)(1e9 + 7);
        
        return C;
    }
    
    public static long[][] powerMatrix(long[][] A, long n) {
        if (n == 1) {
            return A;
        }
        
        if (n % 2 == 0) {
            // n이 짝수인 경우: A^n = (A^(n/2))^2
            long[][] halfPower = powerMatrix(A, n / 2);
            return multiplyMatrix(halfPower, halfPower);
        } else {
            // n이 홀수인 경우: A^n = A * (A^((n-1)/2))^2
            long[][] halfPower = powerMatrix(A, (n - 1) / 2);
            long[][] temp = multiplyMatrix(halfPower, halfPower);
            return multiplyMatrix(A, temp);
        }
    }
    
    public static long fibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long[][] baseMatrix = {
            {1, 1},
            {1, 0}
        };
        
        long[][] resultMatrix = powerMatrix(baseMatrix, n - 1);
        
        return (resultMatrix[0][0]);
    }
}