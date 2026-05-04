/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        // null -> true
        // leaf node -> true
        return dfs(root)[0] == 0;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);

            int[] res = new int[2];
            res[0] = left[0] == 0 && right[0] == 0 && Math.abs(right[1] - left[1]) <= 1 ? 0 : 1;
            res[1] = 1 + Math.max(left[1], right[1]);
            return res;
        }
    }
}
