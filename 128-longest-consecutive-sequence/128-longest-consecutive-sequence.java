class Solution {
  public static int longestConsecutive(int[] nums) {
    Map<Integer, Boolean> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, false);
    }

    int answer = 0;
    for (Map.Entry<Integer, Boolean> item : map.entrySet()) {
      if (map.get(item.getKey())) {
        continue;
      }
      map.put(item.getKey(), true);
      int count = 1;
      int next = item.getKey() + 1;
      while (map.get(next) != null) {
        map.put(next, true);
        count++;
        next++;
      }
      answer = Math.max(answer, count);
    }
    return answer;
  }
}