class Solution {
  public int majorityElement(int[] nums) {
    int owner = 0, count = 0;
    for (int num : nums) {
      if (count == 0) {
        owner = num;
      }
      
      if (owner == num) {
        count++;
      } else {
        count--;
      }
    }
    return owner;
  }
}