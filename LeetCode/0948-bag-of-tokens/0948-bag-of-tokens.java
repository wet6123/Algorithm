class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int start = 0;
        int end = tokens.length - 1;
        int cnt = 0;
        int maxCnt = 0;

        while(start <= end && (power >= tokens[start] || cnt > 0)) {
            while (start <= end && tokens[start] <= power) {
                power -= tokens[start];
                start++;
                cnt++;
            }

            maxCnt = cnt;
            
            if(start <= end && cnt > 0) {
                power += tokens[end];
                end--;
                cnt--;
            }
        }

        return maxCnt;
    }
}