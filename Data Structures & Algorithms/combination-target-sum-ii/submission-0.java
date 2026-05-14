class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> subset, int target, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(subset)); 
        } else if (i >= nums.length || target < 0) {
            return;
        } else {
            subset.add(nums[i]);
            backtrack(nums, res, subset, target - nums[i], i + 1);
            subset.remove(subset.size() - 1);
            int next = i + 1;
            while (next < nums.length && nums[next] == nums[i]) {
                next++;
            }
            backtrack(nums, res, subset, target, next);
        }
    }
}
