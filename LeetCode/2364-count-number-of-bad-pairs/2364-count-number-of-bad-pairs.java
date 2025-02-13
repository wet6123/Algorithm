class Solution {
    public long countBadPairs(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < len; i++) {
            int key = i - nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long goodPairs = 0;
        for (int freq : map.values()) {
            if (freq > 1) {
                goodPairs += (long) freq * (freq - 1) / 2;
            }
        }

        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2;

        return (totalPairs - goodPairs);
    }
}