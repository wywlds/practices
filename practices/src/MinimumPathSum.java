/**
 * Created by yuewenwang on 2017/8/28.
 */
public class MinimumPathSum
{
  public int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] path = new int[m][];
    for (int i = 0 ; i < m ; i ++) {
      path[i] = new int[n];
    }
    for (int i = 0 ; i < m ; i ++) {
      for (int j = 0 ; j < n ; j ++) {
        if (i == 0 && j == 0) {
          path[i][j] = grid[i][j];
        } else if (i == 0) {
          path[i][j] = path[i][j - 1] + grid[i][j];
        } else if (j == 0) {
          path[i][j] = path[i - 1][j] + grid[i][j];
        } else {
          path[i][j] = Math.min(path[i][j-1], path[i - 1][j]) + grid[i][j];
        }
      }
    }
    return path[m - 1][n - 1];
  }

  public static void main(String[] args) {

  }
}
