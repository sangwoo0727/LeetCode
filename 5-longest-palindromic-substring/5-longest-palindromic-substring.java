class Solution {
  public String longestPalindrome(String s) {
    boolean[][] dp = new boolean[s.length()][s.length()];
    String answer = s.substring(0, 1);
    
    for (int i = s.length() - 1; i >= 0; i--) {
      for (int j = i; j < s.length(); j++) {
        dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i <= 2 || dp[i + 1][j - 1]);
        if (dp[i][j] && j - i >= answer.length()) {
          answer = s.substring(i, j + 1);
        }
      }
    }
    return answer;
  }
}