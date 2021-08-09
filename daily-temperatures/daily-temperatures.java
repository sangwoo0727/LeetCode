
class Solution {

  private int[] answer;

  public int[] dailyTemperatures(int[] temperatures) {
    return this.initStore(temperatures.length)
        .findWarmerTemps(temperatures)
        .getAnswer();
  }

  private int[] getAnswer() {
    return answer;
  }

  private Solution findWarmerTemps(int[] temps) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (int idx = temps.length - 1; idx >= 0; idx--) {
      int temp = temps[idx];
      while (!stack.isEmpty() && temp >= temps[stack.peekLast()]) {
        stack.pollLast();
      }
      if (stack.isEmpty()) {
        answer[idx] = 0;
      } else {
        answer[idx] = stack.peekLast() - idx;
      }
      stack.addLast(idx);
    }
    return this;
  }

  private Solution initStore(int size) {
    answer = new int[size];
    return this;
  }
}