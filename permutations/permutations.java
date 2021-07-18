class Solution {

  private List<List<Integer>> permutations;
  private int[] permutation;
  private boolean[] isUsed;

  public List<List<Integer>> permute(int[] nums) {
    this.init(nums)
        .recurFunc(0, nums);

    return permutations;
  }

  private void recurFunc(int k, int[] nums) {
    if (k >= nums.length) {
      addPermutation();
      return;
    }
    for (int idx = 0; idx < nums.length; idx++) {
      if (isUsed[idx]) {
        continue;
      }
      isUsed[idx] = true;
      permutation[k] = nums[idx];
      recurFunc(k + 1, nums);
      isUsed[idx] = false;
    }
  }

  private void addPermutation() {
    List<Integer> list = Arrays.stream(permutation).boxed().collect(Collectors.toList());
    permutations.add(list);
  }

  private Solution init(int[] nums) {
    permutations = new ArrayList<>();
    permutation = new int[nums.length];
    isUsed = new boolean[nums.length];
    return this;
  }
}
