import java.util.Arrays;

/**
 * Created by yuewenwang on 2017/8/29.
 */
public class EditDistance
{
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] pt = new int[m + 1][];
    for (int i = 0 ; i <= m ; i ++) {
      pt[i] = new int[n + 1];
      Arrays.fill(pt[i], 0);
    }
    for (int i = 0 ; i <= m ; i ++) {
      pt[i][0] = i;
    }
    for (int i = 0 ; i <= n ; i ++) {
      pt[0][i] = i;
    }
    for (int i = 1 ; i <= m ; i ++) {
      for (int j = 1 ; j <= n ; j ++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          pt[i][j] = pt[i - 1][j - 1];
        } else {
          pt[i][j] = Math.min(pt[i - 1][j] + 1, Math.min(pt[i][j - 1] + 1, pt[i - 1][j - 1] + 1));
        }
      }
    }
    return pt[m][n];
  }
  public static void main(String[] args) {
    EditDistance ed = new EditDistance();
    System.out.println(ed.minDistance("aaabc", "aaaba"));
  }
}
