/**
 * Created by yuewenwang on 2017/8/24.
 */
public class Pow
{
  public double myPow(double x, int n) {
    int leftmost = 0;
    boolean isNegative = (n < 0);
    long nl = Math.abs((long)n);
    for (int i = 32 ; i >= 0 ; i --) {
      if ((nl & (1L << i)) != 0) {
        leftmost = i + 1;
        break;
      }
    }
    double result = 1;
    for (int i = 0 ; i < leftmost ; i ++) {
      if ((nl & (1L << i)) != 0) {
        result = result * x;
      }
      x = x * x;
    }
    if (isNegative) {
      return 1.0/result;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.print(String.format("%.6f",new Pow().myPow(8.88023, 3)));
  }
}
