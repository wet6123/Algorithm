import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < size; i++) {
            map.put(nums[i], nums[i]);
        }
        int max = map.size();
        int answer = 0;
        if (max > size / 2){
            answer = size / 2;
        } else {
            answer = max;
        }
        return answer;
    }
}