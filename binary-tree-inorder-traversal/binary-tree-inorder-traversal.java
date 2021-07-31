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

  private final Deque<TreeNode> stack = new ArrayDeque<>();
  private final List<Integer> answer = new ArrayList<>();

  public List<Integer> inorderTraversal(TreeNode root) {
    inorder(root);
    return answer;
  }

  private void inorder(TreeNode node) {
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.addLast(node);
        node = node.left;
      }
      node = stack.pollLast();
      answer.add(node.val);
      node = node.right;
    }
  }
}