class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] tasksCount = new int[26];
    for (char task : tasks) {
      tasksCount[task - 'A']++;
    }
    Arrays.sort(tasksCount);

    int maxCount = tasksCount[25];
    int idleTime = n * (maxCount - 1);

    for (int i = 0; i < 25; i++) {
      idleTime -= Math.min(maxCount - 1, tasksCount[i]);
    }

    idleTime = Math.max(0, idleTime);
    return idleTime + tasks.length;
  }
}
