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
  
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return this.generate(preorder, inorder, 0, 0, inorder.length - 1);
  }
  
  private TreeNode generate(int[] preorder, int[] inorder, int preIdx, int inStartIdx, int inEndIdx) {
    if (preIdx >= preorder.length || inStartIdx > inEndIdx) { 
      return null;
    }
    
    int inIdx = 0;
    TreeNode node = new TreeNode(preorder[preIdx]);
    
    for (int i = inStartIdx; i <= inEndIdx; i++) {
      if (node.val == inorder[i]) {
        inIdx = i;
        break;
      }
    }

    node.left = this.generate(preorder, inorder, preIdx + 1, inStartIdx, inIdx - 1);
    node.right = this.generate(preorder, inorder, preIdx + inIdx - inStartIdx + 1, inIdx + 1, inEndIdx);
    return node;
  }
}