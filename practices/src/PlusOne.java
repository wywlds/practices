import java.util.Arrays;

/**
 * Created by yuewenwang on 2017/8/28.
 */
public class PlusOne
{
  public int[] plusOne(int[] digits) {
    boolean isAllNine = true;
    for (int digit : digits) {
      isAllNine &= (digit == 9);
    }
    if (isAllNine) {
      int[] result = new int[digits.length + 1];
      Arrays.fill(result, 0);
      result[0] = 1;
      return result;
    }

    for (int i = digits.length - 1 ; i >= 0 ; i --) {
      digits[i] = (digits[i] + 1) % 10;
      if (digits[i] != 0) {
         break;
      }
    }
    return digits;
  }

  public static void main(String[] args) {
    PlusOne p = new PlusOne();
    int[] result1 = p.plusOne(new int[]{1,9,9});
    int[] result2 = p.plusOne(new int[]{1,0,0});
    for (int item : result1) {
      System.out.print(item);
    }
    System.out.print("\n");
    for (int item : result2) {
      System.out.print(item);
    }
    System.out.print("\n");
  }
}
