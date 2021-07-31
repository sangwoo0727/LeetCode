class Solution {

  private final List<String> parenthesisSet = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    findAll(1, 1, n, "");
    return parenthesisSet;
  }

  private void findAll(int closed, int open, int total, String parenthesis) {
    if (closed > total) {
      parenthesisSet.add(parenthesis);
      return;
    }
    if (open <= total) {
      findAll(closed, open + 1, total, parenthesis + "(");
    }
    if (closed < open) {
      findAll(closed + 1, open, total, parenthesis + ")");
    }
  }
}