class Solution {
  public int maxProduct(int[] nums) {
    int min = nums[0], max = nums[0], result = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      int tmp = max * num;
      max = Math.max(Math.max(tmp, min * num), num);
      min = Math.min(Math.min(tmp, min * num), num);
      result = Math.max(result, max);
    }
    return result;
  }
}