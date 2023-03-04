import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int[] dp = new int[41];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i < 41; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        
        for (int tc = 0; tc < T; tc++) {
            int num = sc.nextInt();
            if (num == 0)
                System.out.println("1 0");
            else if (num == 1)
                System.out.println("0 1");
            else
                System.out.println(dp[num - 1] + " " + dp[num]);
        }
    }
}