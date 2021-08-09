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
    Deque<Pair> stack = new ArrayDeque<>();
    for (int idx = temps.length - 1; idx >= 0; idx--) {
      int temp = temps[idx];
      while (!stack.isEmpty() && temp >= stack.peekLast().getTemp()) {
        stack.pollLast();
      }
      if (stack.isEmpty()) {
        answer[idx] = 0;
      } else {
        Pair next = stack.peekLast();
        answer[idx] = next.getIdx() - idx;
      }
      stack.addLast(new Pair(temp, idx));
    }
    return this;
  }

  private Solution initStore(int size) {
    answer = new int[size];
    return this;
  }
}

class Pair {
  private int temp;
  private int idx;

  public Pair(int temp, int idx) {
    this.temp = temp;
    this.idx = idx;
  }

  public int getIdx() {
    return idx;
  }

  public int getTemp() {
    return temp;
  }
}