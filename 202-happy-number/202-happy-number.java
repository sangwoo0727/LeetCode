class Solution {
  private final Set<Integer> set = new HashSet<>();
  public boolean isHappy(int n) {
    while (true) {
      int sum = 0;
      while (n != 0) {
        int digit = n % 10;
        n /= 10;
        sum += Math.pow(digit, 2);
      }
      if (sum == 1) {
        return true;
      }
      if (set.contains(sum)) {
          return false;
      }
      set.add(sum);
      n = sum;
    }
  }
}