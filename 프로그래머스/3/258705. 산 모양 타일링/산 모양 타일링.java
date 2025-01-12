class Solution {
    public int solution(int n, int[] tops) {
        int mod = (int)1e4 + 7;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = 1;
        dp2[0] = 2 + tops[0];
        
        for(int i = 1; i < n; i++) {
            dp1[i] = (dp1[i - 1] + dp2[i - 1]) % mod;
            dp2[i] = (dp1[i - 1] * (1 + tops[i]) + dp2[i - 1] * (2 + tops[i])) % mod;
        }
        
        return (dp1[n - 1] + dp2[n - 1]) % mod;
    }
}