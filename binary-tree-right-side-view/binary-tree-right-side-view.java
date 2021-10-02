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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    findRightNode(root, 0, answer);
    return answer;
  }

  private void findRightNode(TreeNode node, int height, List<Integer> list) {
    if (node == null) {
      return;
    }
    if (height == list.size()) {
      list.add(node.val);
    }
    findRightNode(node.right, height + 1, list);
    findRightNode(node.left, height + 1, list);
  }
}