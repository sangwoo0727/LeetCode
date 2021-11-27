/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    Queue<TreeNode> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    queue.add(root);
    while(!queue.isEmpty()){
      TreeNode parent = queue.poll();
      if (parent == null) {
        sb.append("null").append(" ");
        continue;
      }
      sb.append(parent.val).append(" ");
      queue.add(parent.left);
      queue.add(parent.right);
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if ("".equals(data)) {
      return null;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    String[] values = data.split(" ");
    TreeNode root = new TreeNode(Integer.parseInt(values[0]));
    queue.add(root);

    for (int i = 1; i < values.length; i++) {
      TreeNode parent = queue.poll();
      String value = values[i];
      if (!"null".equals(value)) {
        TreeNode left = new TreeNode(Integer.parseInt(value));
        parent.left = left;
        queue.add(left);
      }
      i++;
      value = values[i];
      if (!"null".equals(value)) {
        TreeNode right = new TreeNode(Integer.parseInt(value));
        parent.right = right;
        queue.add(right);
      }
    }
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));