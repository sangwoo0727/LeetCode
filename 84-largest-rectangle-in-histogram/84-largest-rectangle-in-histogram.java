class Solution {
  public int largestRectangleArea(int[] heights) {
    int result = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < heights.length; i++) {
      while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
        int height = heights[stack.pollLast()];
        int width = stack.isEmpty() ?
            i : i - stack.peekLast() - 1;
        result = Math.max(result, height * width);
      }
      stack.addLast(i);
    }
    while (!stack.isEmpty()) {
      int height = heights[stack.pollLast()];
      int width = stack.isEmpty() ?
          heights.length : heights.length - stack.peekLast() - 1;
      result = Math.max(result, height * width);
    }

    return result;
  }
}