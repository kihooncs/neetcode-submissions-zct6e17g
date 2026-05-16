class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[i]);
            backtrack(res, subset, nums, i + 1);
            subset.remove(subset.size() - 1);

            int next = i + 1;
            while (next < nums.length && nums[next] == nums[i]) {
                i++;
                next++;
            }
            backtrack(res, subset, nums, next);
        }
    }
}
