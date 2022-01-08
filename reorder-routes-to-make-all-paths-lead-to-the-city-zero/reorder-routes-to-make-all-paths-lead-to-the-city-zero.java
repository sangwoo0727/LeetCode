class Solution {

  private boolean[] visit;
  private List<List<Integer>> lists;

  public int minReorder(int n, int[][] connections) {
    visit = new boolean[n];
    lists = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      lists.add(new ArrayList<>());
    }
    for (int[] edge : connections) {
      int u = edge[0];
      int v = edge[1];
      lists.get(u).add(v);
      lists.get(v).add(-u);
    }
    return dfs(0);
  }

  private int dfs(int start) {
    
    visit[start] = true;
    int cnt = 0;
    for (int next : lists.get(start)) {
      if (visit[Math.abs(next)]) {
        continue;
      }
      cnt += dfs(Math.abs(next));
      cnt += next > 0 ? 1 : 0;
    }
    return cnt;
  }
}