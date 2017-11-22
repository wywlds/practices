/**
 * Created by yuewenwang on 2017/8/23.
 */
public class MultiplyStrings
{
  public String multiply(String num1, String num2) {
    CharSequence left = num1;
    CharSequence right = num2;
    CharSequence result = null;
    for (int i = right.length() - 1 , j = 0; i >= 0 ; i -- , j ++) {
      if (right.charAt(i) == 0) {
        continue;
      }
      CharSequence multiplyResult = multiplyOne(left, right.charAt(i));
      StringBuilder builder = new StringBuilder(multiplyResult);
      for (int k = 0 ; k < j ; k ++) {
        builder.append(0);
      }
      if (result == null) {
        result = builder;
      } else {
        result = add(result, builder);
      }
    }
    StringBuilder returned = new StringBuilder(result);
    stripZero(returned);
    return returned.toString();
  }

  public void stripZero(StringBuilder seq) {
    int len = seq.length();
    for (int i = 0 ; i < len - 1 ; i ++) {
      if (Character.getNumericValue(seq.charAt(0)) != 0) {
        break;
      }
      seq.deleteCharAt(0);
    }
  }

  public CharSequence multiplyOne(CharSequence num1, char num2) {
    StringBuilder builder = new StringBuilder();
    int residue = 0;
    for (int i = num1.length() - 1; i >= 0 ; i --) {
       int result = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2);
       result += residue;
       builder.append(result % 10);
       residue = result / 10;
    }
    if (residue != 0) {
      builder.append(residue);
    }
    return builder.reverse();
  }

  public CharSequence add(CharSequence left, CharSequence right) {
    StringBuilder builder = new StringBuilder();
    int residue = 0;
    for (int i = left.length() - 1, j = right.length() -1 ; i >= 0 || j >= 0 ; i -- , j --) {
      int leftNum = Character.getNumericValue(i >= 0 ? left.charAt(i) : '0');
      int rightNum = Character.getNumericValue(j >= 0 ? right.charAt(j) : '0');
      int result = leftNum + rightNum + residue;
      builder.append(result % 10);
      residue = result / 10;
    }
    if (residue != 0) {
      builder.append(residue);
    }
    return builder.reverse();
  }

  public static void main(String[] args)
  {
    System.out.println(String.format("The first Element: %s", args[0]));
    System.out.println(String.format("The second Element: %s", args[1]));

    System.out.println(String.format("The result Element: %s", new MultiplyStrings().multiply("9133", "0")));
  }
}
