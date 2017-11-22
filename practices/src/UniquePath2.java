import java.util.Arrays;

/**
 * Created by yuewenwang on 2017/8/28.
 */
public class UniquePath2
{
  public int uniquePathsWithObstacles(int[][] obstacleGrid)
  {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] path = new int[m][];
    for (int i = 0; i < m; i++) {
      path[i] = new int[n];
    }
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (obstacleGrid[i][j] == 1) {
            path[i][j] = 0;
            continue;
          }
          if (i == 0 && j == 0) {
            path[i][j] = 1;
          } else if (i == 0) {
            path[i][j] = path[i][j - 1];
          } else if (j == 0) {
            path[i][j] = path[i - 1][j];
          } else {
            path[i][j] = path[i - 1][j] + path[i][j - 1];
          }
        }
    }
    return path[m - 1][n - 1];
  }

  public static void main(String[] args) {
    int m = 3;
    int n = 3;
    int[][] path = new int[3][];
    for (int i = 0 ; i < m ; i ++) {
      path[i] = new int[n];
      Arrays.fill(path[i], 0 );
    }
    path[1][1] = 1;
    System.out.print(new UniquePath2().uniquePathsWithObstacles(path));
  }

}
