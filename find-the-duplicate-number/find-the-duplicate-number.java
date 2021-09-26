class Solution {
  public int findDuplicate(int[] nums) {
    int answer = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      int checkIdx = Math.abs(nums[i]);
      if (nums[checkIdx] < 0) {
        answer = checkIdx;
        break;
      }
      nums[checkIdx] *= -1;
    }
    return answer;
  }
}