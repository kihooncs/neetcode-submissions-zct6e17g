class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> perm = permute(Arrays.copyOfRange(nums, 1, nums.length));
        for (List<Integer> p : perm) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> pCopy = new ArrayList<>(p);
                pCopy.add(i, nums[0]);
                res.add(pCopy);
            }
        }
        return res;
        
    }

    
}
