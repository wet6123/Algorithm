import java.util.HashMap;

class Solution {
    static int N;
    static int[] sum, ref;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        N = enroll.length;
        sum = new int[N];
        HashMap<String, Integer> index = new HashMap<>();
        for(int i = 0; i < N; i++) {
            index.put(enroll[i], i);
        }
        index.put("-", N);
        
        ref = new int[N + 1];
        for(int i = 0; i < N; i++) {
            ref[i] = index.get(referral[i]);
        }
        
        int m = seller.length;
        for(int i = 0; i < m; i++) {
            calc(index.get(seller[i]), amount[i] * 100);
        }
        
        return sum;
    }
    
    private void calc(int idx, int num) {
        if (idx == N) return;
        sum[idx] += num - (num / 10);
        calc(ref[idx], num / 10);
    }
}