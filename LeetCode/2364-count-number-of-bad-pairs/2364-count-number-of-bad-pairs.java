class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            int key = i - nums[i];
            int cnt =  map.getOrDefault(key, 0);
            ans += i - cnt;
            map.put(key, cnt + 1);
        }

        return ans;
    }
}