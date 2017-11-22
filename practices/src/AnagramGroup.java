import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuewenwang on 2017/8/24.
 */
public class AnagramGroup
{
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      String mark = generateMark(str);
      if (map.containsKey(mark)) {
        map.get(mark).add(str);
      } else {
        ArrayList<String> list = new ArrayList<>();
        list.add(str);
        map.put(mark, list);
      }
    }
    ArrayList<List<String>> result = new ArrayList<>(map.values());
    return result;
  }

  public String generateMark(String str) {
    HashMap<Character, Integer> counter = new HashMap<>();
    char[] chars = str.toCharArray();
    for (char c : chars) {
      Character C = new Character(c);
      if (counter.containsKey(C)) {
        counter.put(C, counter.get(C) + 1);
      } else {
        counter.put(C, 1);
      }
    }
    StringBuilder sb = new StringBuilder();
    ArrayList<Map.Entry<Character,Integer>> list = new ArrayList<>();
    list.addAll(counter.entrySet());
    list.sort(new Comparator<Map.Entry<Character, Integer>>()
    {
      @Override
      public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2)
      {
        return o1.getKey().compareTo(o2.getKey());
      }
    });

    for (Map.Entry<Character, Integer> k : list) {
      sb.append(k.getKey());
      sb.append(k.getValue());
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(new AnagramGroup().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
}
}
