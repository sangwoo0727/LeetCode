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

  private int longestDepth = 0;
  public int maxDepth(TreeNode root) {
    dfs(root, 0);
    return longestDepth;
  }

  private void dfs(TreeNode node, int depth) {
    if (node == null) {
      return;
    }
    depth += 1;
    longestDepth = Math.max(longestDepth, depth);
    dfs(node.left, depth);
    dfs(node.right, depth);
  }
}