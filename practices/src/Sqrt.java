/**
 * Created by yuewenwang on 2017/8/28.
 */
public class Sqrt
{
  public int mySqrt(int x) {
    float tmp = 1;
    while(true) {
      float deltaY = (float)x - tmp * tmp;
      float deltaX = deltaY / (tmp * 2);
      float newTmp = tmp + deltaX;
      if (Math.abs(deltaX) < 0.1) {
        int result = (int) tmp;
        if (result * result > x) {
          return result - 1;
        }
        return (int)tmp;
      }
      tmp = newTmp;
    }
  }

  public static void main(String[] args) {
    Sqrt sqrt = new Sqrt();
    System.out.println(sqrt.mySqrt(2147395599));
    for (int i = 1 ; i < 100 ; i ++) {
      System.out.println(sqrt.mySqrt(i));

    }
  }
}
