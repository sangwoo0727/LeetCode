class Solution {
  public void sortColors(int[] nums) {
    int left = 0, right = nums.length - 1;
    for (int i = 0; i <= right; ) {
      if (nums[i] == 0) {
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left++] = temp;
        i++;
      } else if (nums[i] == 2) {
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right--] = temp;
      } else {
        i++;
      }
    }
  }
}