import sun.security.provider.ConfigFile;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuewenwang on 2017/8/25.
 */
public class SpiralOrder
{
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new LinkedList<>();
    int n = matrix.length;
    int m = n!=0? matrix[0].length:0;
    int pi = 0;
    int pj = 0;
    for (pj = 0 ; pj < m ; pj ++) {
      result.add(new Integer(matrix[pi][pj]));
    }
    n --; m --;
    pj --;
    while (n > 0 && m > 0){
      int stepn = 0;
      int stepm = 0;
      if (pj > pi) {
        for(; stepn < n ;stepn ++) {
          pi ++;
          result.add(new Integer(matrix[pi][pj]));
        }
        n --;
        for(;stepm < m ;  stepm ++) {
          pj --;
          result.add(new Integer(matrix[pi][pj]));
        }
        m --;
      } else {
        for(; stepn < n ; stepn ++) {
        pi --;
        result.add(new Integer(matrix[pi][pj]));
      }
        n --;
        for(;stepm < m ; stepm ++) {
          pj ++;
          result.add(new Integer(matrix[pi][pj]));
        }
        m --;
      }
    }
    int stepn = 0;
    if (n > 0) {
      if (pj >= pi) {
        for(; stepn < n ;stepn ++) {
          pi ++;
          result.add(new Integer(matrix[pi][pj]));
        }
      } else {
        for(; stepn < n ; stepn ++) {
          pi --;
          result.add(new Integer(matrix[pi][pj]));
        }
      }
    }
    return result;
  }
  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1}, {2}, {3},{4}};
    matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
    matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
    matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
    System.out.println(new SpiralOrder().spiralOrder(matrix));
  }
}
