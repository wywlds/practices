/**
 * Created by yuewenwang on 2017/8/29.
 */
public class Search2DMatrix
{
  public boolean searchMatrix(int[][] matrix, int target)
  {
    int Threshold = 5;
    int start = 0;
    int end = matrix.length;
    int row = 0;

    if (end == 0) {
      return false;
    } else if (matrix[0].length == 0) {
      return false;
    }

    while(true) {
      if (end - start <= Threshold) {
        for (int i = start; i < end; i++) {
          if (i == matrix.length - 1 || matrix[i + 1][0] > target) {
            row = i;
            break;
          }
        }
        if (matrix[row][0] > target) {
          return false;
        }
        break;
      }
      int middle = (end + start) / 2;
      if (matrix[middle][0] > target) {
        end = middle;
      } else {
        start = middle;
      }
    }

    start = 0;
    end = matrix[0].length;
    while(true) {
      if (end - start <= Threshold) {
        for (int i = start ; i < end ; i ++) {
          if (matrix[row][i] == target) {
            return true;
          }
        }
        return false;
      }
      int middle = (start + end) / 2;
      if (matrix[row][middle] > target) {
        end = middle;
      } else {
        start = middle;
      }
    }
  }
}
