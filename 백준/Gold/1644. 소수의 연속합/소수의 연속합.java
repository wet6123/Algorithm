import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        
        List<Integer> primes = generatePrimes(n);
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        
        while (left < primes.size()) {
            // 합이 n보다 작고 right가 범위 내에 있으면 오른쪽으로 확장
            if (sum < n && right < primes.size()) {
                sum += primes.get(right);
                right++;
            } 
            // 합이 n보다 크거나 같거나 right가 범위를 벗어나면 왼쪽 포인터 이동
            else {
                sum -= primes.get(left);
                left++;
            }
            
            // 합이 n과 같으면 경우의 수 증가
            if (sum == n) {
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    public static List<Integer> generatePrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
}