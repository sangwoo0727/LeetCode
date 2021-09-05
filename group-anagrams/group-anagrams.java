class Solution {

  private final Map<String, List<String>> map = new HashMap<>();

  public List<List<String>> groupAnagrams(String[] strs) {
    Arrays.stream(strs).forEach(this::mappingWord);
    return new ArrayList<>(map.values());
  }

  private void mappingWord(String str) {
    String key = makeKeyFromStr(str);
    putIntoMap(key, str);
  }

  private void putIntoMap(String key, String value) {
    map.put(key, map.getOrDefault(key, new ArrayList<>()));
    List<String> list = map.get(key);
    list.add(value);
  }

  private String makeKeyFromStr(String str) {
    char[] strArrays = str.toCharArray();
    Arrays.sort(strArrays);
    return String.valueOf(strArrays);
  }
}