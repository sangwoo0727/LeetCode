class Solution {

  private final Deque<String> stack = new ArrayDeque<>();
  private final Deque<Integer> numberStack = new ArrayDeque<>();

  public String decodeString(String s) {
    StringBuilder output = new StringBuilder();
    StringBuilder numberBuilder = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (Character.isDigit(c)) {
        numberBuilder.append(c);
      } else if (c == '[') {
        numberStack.addLast(Integer.parseInt(numberBuilder.toString()));
        stack.addLast(output.toString());
        numberBuilder = new StringBuilder();
        output = new StringBuilder();
      } else if (c == ']') {
        StringBuilder temp = new StringBuilder(stack.pollLast());
        int count = numberStack.pollLast();
        while (count-- > 0) {
          temp.append(output);
        }
        output = temp;
      } else {
        output.append(c);
      }
    }
    return output.toString();
  }
}
