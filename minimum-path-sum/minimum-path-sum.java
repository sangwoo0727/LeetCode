class Solution {

  private int[][] dist;
  private final int[][] dir = {{0, 1}, {1, 0}};

  public int minPathSum(int[][] grid) {
    int N = grid.length;
    int M = grid[0].length;
    dist = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        dist[i][j] = -1;
      }
    }
    dist[0][0] = grid[0][0];
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(0, 0));

    while (!q.isEmpty()) {
      Pair now = q.poll();
      for (int k = 0; k < 2; k++) {
        int nn = now.getN() + dir[0][k];
        int nm = now.getM() + dir[1][k];
        if (inner(nn, nm, N, M) && canGo(now.getN(), now.getM(), nn, nm, grid)) {
          dist[nn][nm] = dist[now.getN()][now.getM()] + grid[nn][nm];
          q.add(new Pair(nn, nm));
        }
      }
    }
    return dist[N - 1][M - 1];
  }

  private boolean canGo(int n, int m, int nn, int nm, int[][] grid) {
    return dist[nn][nm] == -1 || dist[n][m] + grid[nn][nm] < dist[nn][nm];
  }

  private boolean inner(int n, int m, int N, int M) {
    return 0 <= n && n < N && 0 <= m && m < M;
  }
}

class Pair {
  private int n;
  private int m;

  public Pair(int n, int m) {
    this.n = n;
    this.m = m;
  }
  public int getN() {
    return n;
  }
  public int getM() {
    return m;
  }
}
