class Solution {
    public int[] searchRange(int[] nums, int target) {
        boolean flag = false;
        int[] position = {-1, -1};
        int i = 0;
        while(i < nums.length) {
            if (nums[i] == target) {
                position[0] = position[1] = i;
                flag = false;
                break;
            }
            i++;
        }

        i = nums.length - 1;
        while(i >= 0) {
            if (flag) break;
            if (nums[i] == target) {
                position[1] = i;
                break;
            }
            i--;
        }

        return position;
    }
}