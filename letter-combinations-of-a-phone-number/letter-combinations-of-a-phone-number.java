class Solution {

  private static final Map<String, List<Character>> map = Map.of(
      "2", List.of('a', 'b', 'c'),
      "3", List.of('d', 'e', 'f'),
      "4", List.of('g', 'h', 'i'),
      "5", List.of('j', 'k', 'l'),
      "6", List.of('m', 'n', 'o'),
      "7", List.of('p', 'q', 'r', 's'),
      "8", List.of('t', 'u', 'v'),
      "9", List.of('w', 'x', 'y', 'z')
  );

  private final List<String> answer = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if ("".equals(digits)) {
      return answer;
    }
    String[] list = digits.split("");
    dfs(0, list, "");
    return answer;
  }

  private void dfs(int idx, String[] list, String line) {
    if (idx == list.length) {
      answer.add(line);
      return;
    }
    for (char alp : map.get(list[idx])) {
      dfs(idx + 1, list, line + alp);
    }
  }
}