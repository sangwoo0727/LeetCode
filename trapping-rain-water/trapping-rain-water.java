class Solution {
  public int trap(int[] height) {
    int ans = 0;
    int len = height.length;
    int[] rightMax = new int[height.length];
    int[] leftMax = new int[height.length];
    
    int left = 0, right = 0;
    for (int i = 0; i < len; i++) {
      left = Math.max(left, height[i]);
      leftMax[i] = left;

      right = Math.max(right, height[len - i - 1]);
      rightMax[len - i - 1] = right;
    }

    for (int i = 0; i < len; i++) {
      ans += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return ans;
  }
}