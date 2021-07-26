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

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> inorders = new ArrayList<>();
    inorder(root, inorders);
    return inorders;
  }

  private void inorder(TreeNode node, List<Integer> inorders) {
    if (node == null) {
      return;
    }
    inorder(node.left, inorders);
    inorders.add(node.val);
    inorder(node.right, inorders);
  }
}