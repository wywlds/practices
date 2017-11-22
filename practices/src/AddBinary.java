/**
 * Created by yuewenwang on 2017/8/28.
 */
public class AddBinary
{
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    char[] ac = a.toCharArray();
    char[] bc = b.toCharArray();
    int residue = 0;
    for (int i = 0; i < Math.max(ac.length, bc.length) ; i ++) {
      int left = i < ac.length? (ac[ac.length - 1 - i] == '1'? 1:0):0;
      int right = i < bc.length? (bc[bc.length - 1 - i] == '1'? 1:0):0;
      int sum = left + right + residue;
      residue = sum/2;
      sb.append(sum%2);
    }
    if (residue != 0) {
      sb.append(residue);
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    AddBinary p = new AddBinary();
    System.out.print(p.addBinary("100", "111"));
  }
}
