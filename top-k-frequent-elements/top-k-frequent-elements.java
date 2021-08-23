class Solution {

  private Map<Integer, Integer> countMap;
  private List<List<Integer>> lists;

  public int[] topKFrequent(int[] nums, int k) {
    return this.init(nums)
        .countEachNum(nums)
        .sortMapDatas()
        .getTopElements(k);
  }

  private int[] getTopElements(int k) {
    int[] answer = new int[k];
    int idx = 0;
    for (int i = lists.size() - 1; i >= 0; i--) {
      for (int num : lists.get(i)) {
        if (idx < k) {
          answer[idx++] = num;
        }
      }
    }
    return answer;
  }

  private Solution sortMapDatas() {
    for (int num : countMap.keySet()) {
      int count = countMap.get(num);
      lists.get(count).add(num);
    }
    return this;
  }

  private Solution countEachNum(int[] nums) {
    for (int num : nums) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }
    return this;
  }

  private Solution init(int[] nums) {
    countMap = new HashMap<>();
    lists = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      lists.add(new ArrayList<>());
    }
    return this;
  }
}