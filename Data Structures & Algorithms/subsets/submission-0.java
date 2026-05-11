class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int currSize = res.size();
            for (int i = 0; i < currSize; i++) {
                List<Integer> curr = new ArrayList<>(res.get(i));
                curr.add(num);
                res.add(curr);
            }
        }   
        return res;
    }
}
