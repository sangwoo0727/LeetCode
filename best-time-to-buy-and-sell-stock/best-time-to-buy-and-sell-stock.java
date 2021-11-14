class Solution {
  public int maxProfit(int[] prices) {
    int buyPrice = Integer.MAX_VALUE;
    int answer = 0;
    for (int price : prices) {
      if (buyPrice > price) {
        buyPrice = price;
      } else {
        answer = Math.max(answer, price - buyPrice);
      }
    }
    return answer;
  }
}