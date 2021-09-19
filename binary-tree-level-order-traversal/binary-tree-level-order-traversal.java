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

  public List<List<Integer>> levelOrder(TreeNode root) {
    return bfs(root);
  }

  private List<List<Integer>> bfs(TreeNode first) {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(first);
    while (!q.isEmpty()) {
      List<Integer> levAns = new ArrayList<>();
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = q.poll();
        if (treeNode == null) {
          continue;
        }
        levAns.add(treeNode.val);
        q.add(treeNode.left);
        q.add(treeNode.right);
      }
      if (levAns.size() != 0) {
        ans.add(levAns);  
      }
    }
    return ans;
  }
}