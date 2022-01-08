class Solution {
  public int[] replaceElements(int[] arr) {
    int[] result = new int[arr.length];
    Arrays.fill(result, -1);
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        result[i] = Math.max(result[i], arr[j]);
      }
    }
    return result;
  }
}