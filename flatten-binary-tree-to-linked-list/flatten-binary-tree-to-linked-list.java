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
  private TreeNode temp;

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }  
    preorder(root);
    temp.left = null;
  }

  private void preorder(TreeNode node) {
    if (node == null) {
      return;
    }
    preorder(node.right);
    preorder(node.left);
    node.right = temp;
    node.left = null;
    temp = node;
  }
}