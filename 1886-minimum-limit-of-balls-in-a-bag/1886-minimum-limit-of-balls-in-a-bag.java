class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int ans = Integer.MAX_VALUE;
        int start = 1;
        int end = 0;

        for(int num : nums)
            end = Math.max(num, end);

        int numOfBags = nums.length + maxOperations;

        while(start <= end) {
            int mid = (start + end) / 2;

            if (checkNumOfBags(mid, nums, numOfBags)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public boolean checkNumOfBags(int targetNum, int[] nums, int numOfBags) {
        int requiredNumOfBags = 0;

        for(int num : nums) {
            requiredNumOfBags += num / targetNum;
            if (num % targetNum != 0)
                requiredNumOfBags++;
        }

        return (requiredNumOfBags <= numOfBags);
    }
}