class Solution {
  public int singleNumber(int[] nums) {
    int digit = 0;
    for (int num : nums) {
      digit ^= num;
    }
    return digit;
  }
}