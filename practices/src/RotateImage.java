/**
 * Created by yuewenwang on 2017/8/24.
 */
public class RotateImage
{
  public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0 ; i < (n + 1)/2 ; i ++) {
      for (int j = 0; j < n/2 ; j ++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[n - 1 - i][j];
        matrix[n - 1 - i][j] = matrix[n - 1 - j][n - 1 - i];
        matrix[n - 1 - j][n - 1 - i] = matrix[i][n - 1 - j];
        matrix[i][n - 1 - j] = tmp;
      }
    }
  }
}
