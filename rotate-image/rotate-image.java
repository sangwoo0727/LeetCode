class Solution {

  public void rotate(int[][] matrix) {
    reverseTopAndBottom(matrix);
    reverseDiagonal(matrix);
  }

  private void reverseTopAndBottom(int[][] matrix) {
    for (int i = 0; i < matrix.length / 2; i++) {
      for (int j = 0; j < matrix.length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[matrix.length - 1 - i][j];
        matrix[matrix.length - 1 - i][j] = temp;
      }
    }
  }

  private void reverseDiagonal(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j <= i; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
}