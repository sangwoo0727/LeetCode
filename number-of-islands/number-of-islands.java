class Solution {
  private boolean[][] visit;
  private int N, M, answer;

  public int numIslands(char[][] grid) {
    N = grid.length;
    M = grid[0].length;
    answer = 0;
    visit = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (grid[i][j] == '1' && !visit[i][j]) {
          bfs(i, j, grid);
        }
      }
    }
    return answer;
  }

  private void bfs(int sn, int sm, char[][] grid) {
    int[][] dir = {{0, 0, -1, 1}, {1, -1, 0, 0}};
    Queue<Pair> queue = new LinkedList<>();
    visit[sn][sm] = true;
    queue.add(new Pair(sn, sm));

    while (!queue.isEmpty()) {
      Pair now = queue.poll();
      for (int k = 0; k < 4; k++) {
        int nn = now.n + dir[0][k];
        int nm = now.m + dir[1][k];
        if (inner(nn, nm, grid)) {
          visit[nn][nm] = true;
          queue.add(new Pair(nn, nm));
        }
      }
    }
    answer++;
  }

  private boolean inner(int n, int m, char[][] grid) {
    return 0 <= n && n < N && 0 <= m && m < M && !visit[n][m] && grid[n][m] == '1';
  }
}

class Pair {
  int n, m;
  public Pair(int n, int m) {
    this.n = n;
    this.m = m;
  }
}