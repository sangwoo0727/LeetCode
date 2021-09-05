class Solution {

  private final List<List<Integer>> answer = new ArrayList<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    combination(0, 0, candidates, target, new ArrayList<>());
    return answer;
  }

  private void combination(int k, int total, int[] candidates, int target, List<Integer> list) {
    if (total == target) {
      answer.add(List.copyOf(list)); 
      return;
    }
    for (int i = k; i < candidates.length; i++) {
      if (total + candidates[i] > target) {
        break;
      }
      list.add(candidates[i]);
      combination(i, total + candidates[i], candidates, target, list);
      list.remove(list.size() - 1);
    }
  }
}