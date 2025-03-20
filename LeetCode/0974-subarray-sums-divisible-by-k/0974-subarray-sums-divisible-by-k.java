class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] count = new int[k];
        count[0] = 1;
        
        int prefixSum = 0;
        int ans = 0;
        
        for (int num : nums) {
            prefixSum = (prefixSum + num) % k;
            if (prefixSum < 0) prefixSum += k;
            ans += count[prefixSum];
            count[prefixSum]++;
        }
        
        return ans;
    }
}