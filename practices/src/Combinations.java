import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuewenwang on 2017/8/30.
 */
public class Combinations
{
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> container = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();
    combineInternal(container, comb, 1 , n, k);
    return container;
  }

  public void combineInternal(List<List<Integer>> container, List<Integer> comb, int start, int end, int k) {
    if (k == 0) {
      List<Integer> comb2 = new ArrayList<>(comb);
      container.add(comb2);
      return;
    }
    for (int i = start; i <= end - k + 1 ; i ++) {
      comb.add(i);
      combineInternal(container, comb, i + 1, end, k - 1);
      comb.remove(comb.size() - 1);
    }

  }

  public static void main(String[] args) {
    Combinations c = new Combinations();
    List<List<Integer>> result = c.combine(5, 3);
    for (List<Integer> l : result) {
      System.out.print("\t[");
      for (Integer i : l) {
        System.out.print(String.format("%d,",i));
      }
      System.out.print("]\n");
    }
  }
}
