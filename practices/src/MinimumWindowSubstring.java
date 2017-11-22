import java.util.HashMap;

/**
 * Created by yuewenwang on 2017/8/29.
 */
public class MinimumWindowSubstring
{
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (Character c : t.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    int counter = t.length();
    int head=0;
    int length=Integer.MAX_VALUE;
    int pstart = 0;
    int pend = 0;
    for (int i = 0 ; i < s.length() ; i ++) {
      Character cur = s.charAt(i);
      if (map.containsKey(cur)) {
        map.put(cur, map.get(cur) - 1);
        if (map.get(cur) >= 0) counter --;
      }
      while(counter == 0) {
        if (length > (i - pstart)) {
          length = i - pstart;
          head = pstart;
        }
        Character c = s.charAt(pstart);
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
          if (map.get(c) > 0) {
            counter ++;
          }
        }
        pstart ++;
      }
    }
    return length == Integer.MAX_VALUE ? "" : s.substring(head, head + length + 1);
  }

  public static void main(String[] args) {
    System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC"));
  }

}
