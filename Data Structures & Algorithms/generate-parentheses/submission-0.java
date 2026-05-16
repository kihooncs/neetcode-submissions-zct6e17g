class Solution {
    /*
    parenthes
    */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, n, 0, 0, "");
        return res;
    }

    private void backtrack(List<String> res, int n, int open, int close, String subset) {
        if (open == n && close == n) {
            res.add(subset);
        } else {
            if (open < n) {
                backtrack(res, n, open + 1, close, subset + "(");
            }
            if (close < open) {
                backtrack(res, n, open, close + 1, subset + ")");
            }
        }
    }
}
