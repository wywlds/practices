/**
 * Created by yuewenwang on 2017/8/23.
 */
public class WildCardMatching
{
  public boolean isMatchInternal(String s, String p) {
    if (p.length() == 0 && s.length() == 0) {
      return true;
    }
    if (p.length() == 0) {
      return false;
    }
    if (s.length() == 0 && p.charAt(0) != '*') {
      return false;
    }

    char curP = p.charAt(0);
    if (curP == '?') {
      return isMatchInternal(s.substring(1), p.substring(1));
    } else if (curP == '*') {
      for (int i = 0 ; i <= s.length() ; i ++) {
        String left = s.substring(i);
        String right = p.substring(1);
        boolean match = isMatchInternal(left, right);
        if (match) {
          return true;
        }
      }
      return false;
    } else {
      if (curP == s.charAt(0)) {
        return isMatchInternal(s.substring(1), p.substring(1));
      } else {
        return false;
      }
    }
  }

  public boolean isMatch(String s, String p) {
    if (p.length() == 0) {
      return isMatchInternal(s,p);
    }
    char lastChar = p.charAt(0);
    StringBuilder sb = new StringBuilder();
    sb.append(lastChar);
    for (int i = 1 ; i < p.length() ; i ++) {
      char cur = p.charAt(i);
      if (lastChar == '*' && cur == '*') {
        continue;
      }
      lastChar = cur;
      sb.append(cur);
    }
    return isMatchInternal(s, sb.toString());
  }

  public static void main(String[] args) {
    String left = "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab";
    String right = "*aabb***aa**a******aa*";
    System.out.println(String.format("isMatch(%s,%s) -> %s", left,right,new WildCardMatching().isMatch(left,right)));
  }
}
