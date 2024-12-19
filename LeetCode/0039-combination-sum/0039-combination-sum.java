class Solution {
    static List<List<Integer>> ans;
    static List<Integer> selected;
    static int[] candidate_nums;
    static int target_num;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        selected = new ArrayList<>();
        candidate_nums = candidates;
        target_num = target;
        
        for(int i = 0; i < candidate_nums.length; i++) {
            if (candidate_nums[i] <= target_num) {
                selected.add(candidate_nums[i]);
                find(candidate_nums[i], i);
                selected.remove(selected.size() - 1);
            }
        }

        return ans;    
    }

    public void find(int sum, int idx) {
        if (sum == target_num) {
            ans.add(new ArrayList(selected));
            return;
        }

        for(int i = idx; i < candidate_nums.length; i++) {
            if (sum + candidate_nums[i] <= target_num) {
                selected.add(candidate_nums[i]);
                find(sum + candidate_nums[i], i);
                selected.remove(selected.size() - 1);
            }
        }
    }
}