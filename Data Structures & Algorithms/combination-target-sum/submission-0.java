class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> subset, int[] nums, int i, int target) {
        if (i >= nums.length || target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[i]);
            dfs(res, subset, nums, i, target - nums[i]);
            subset.remove(subset.size() - 1);
            dfs(res, subset, nums, i + 1, target);
        }
    }
}
