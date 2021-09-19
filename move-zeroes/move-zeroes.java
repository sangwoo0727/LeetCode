class Solution {

  public void moveZeroes(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] != 0) {
        continue;
      }
      for (int j = i + 1; j < len; j++) {
        if (nums[j] != 0) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
          break;
        }
      }
    }
  }
}