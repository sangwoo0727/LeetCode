import java.util.ArrayList;
import java.util.List;

class Solution {

  private final int[] lastIndexMap = new int[26];

  public List<Integer> partitionLabels(String s) {
    return this.preprocess(s)
        .process(s);
  }

  private List<Integer> process(String s) {
    List<Integer> list = new ArrayList<>();
    int left = 0, right = 0;
    for (int i = 0; i < s.length(); i++) {
      if (i > right) {
        list.add(right - left + 1);
        left = i;
      }
      right = Math.max(right, lastIndexMap[s.charAt(i) - 'a']);
    }
    list.add(right - left + 1);
    return list;
  }

  private Solution preprocess(String s) {
    for (int i = 0; i < s.length(); i++) {
      lastIndexMap[s.charAt(i) - 'a'] = i;
    }
    return this;
  }
}