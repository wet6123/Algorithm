class Solution {
    public int[] searchRange(int[] nums, int target) {
        boolean flag = true;
        int[] position = {-1, -1};

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (flag) {
                    position[0] = position[1] = i;
                    flag = false;
                } else {
                    position[1] = i;
                }
            }
        }

        return position;
    }
}