class Solution {

  private final List<List<Integer>> results = new ArrayList<>();

  public List<List<Integer>> subsets(int[] nums) {
    findPowerSet(0, nums, new ArrayList<>());
    return results;
  }

  private void findPowerSet(int start, int[] nums, List<Integer> subset) {
    addSubsetToResults(subset);

    for (int i = start; i < nums.length; i++) {
      subset.add(nums[i]);
      findPowerSet(i + 1, nums, subset);
      subset.remove(subset.size() - 1);
    }
  }

  private void addSubsetToResults(List<Integer> subset) {
    results.add(new ArrayList<>(subset));
  }
}