class Solution {

  private Map<Integer, Integer> countMap;
  private List<Integer>[] lists;

  public int[] topKFrequent(int[] nums, int k) {
    return this.init(nums)
        .countEachNum(nums)
        .sortMapDatas()
        .getTopElements(k);
  }
  
  private int[] getTopElements(int k) {
    int[] answer = new int[k];
    int idx = 0;
    for (int i = lists.length - 1; i >= 0; i--) {
      if (lists[i] == null) {
        continue;
      }
      for (int num : lists[i]) {
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
      if (lists[count] == null) {
        lists[count] = new ArrayList<>();
      }
      lists[count].add(num);
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
    lists = new List[nums.length + 1];
    return this;
  }
}