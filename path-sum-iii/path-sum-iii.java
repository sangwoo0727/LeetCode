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
  private int count = 0;

  public int pathSum(TreeNode root, int targetSum) {
    pathSum(root, targetSum, new ArrayList<>());
    return count;
  }

  private void pathSum(TreeNode node, int targetSum, List<Integer> prevList) {
    if (node == null) {
      return;
    }

    List<Integer> nowList = new ArrayList<>();
    if (node.val == targetSum) {
      count++;
    }
    nowList.add(node.val);
    for (int prevSum : prevList) {
      int nowSum = prevSum + node.val;
      if (nowSum == targetSum) {
        count++;
      }
      nowList.add(nowSum);
    }
    pathSum(node.left, targetSum, nowList);
    pathSum(node.right, targetSum, nowList);
  }
}