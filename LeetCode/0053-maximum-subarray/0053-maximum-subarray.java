class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];    // 전체 최대 합
        int maxEndingHere = nums[0];    // 현재 위치까지의 최대 합
        
        for (int i = 1; i < nums.length; i++) {
            // 현재 원소부터 시작하는 것이 더 큰지, 이전 합에 현재 원소를 더하는 것이 더 큰지 비교
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            // 전체 최대값 갱신
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}