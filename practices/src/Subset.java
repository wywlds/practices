import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuewenwang on 2017/8/30.
 */
public class Subset
{

  public void combineInternal(List<List<Integer>> container, List<Integer> comb, int[] nums, int start, int end, int k) {
    if (k == 0) {
      List<Integer> comb2 = new ArrayList<>(comb);
      container.add(comb2);
      return;
    }
    for (int i = start; i <= end - k + 1 ; i ++) {
      comb.add(nums[i - 1]);
      combineInternal(container, comb, nums,i + 1, end, k - 1);
      comb.remove(comb.size() - 1);
    }

  }
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    for (int i = 0 ; i <= nums.length ; i ++) {
      combineInternal(subsets, new ArrayList<>(), nums, 1, nums.length, i);
    }
    return subsets;
  }
  public static void main(String[] args) {
    Subset s = new Subset();
    List<List<Integer>> result = s.subsets(new int[]{2,3,4,5});
    for (List<Integer> l : result) {
      System.out.print("\t[");
      for (Integer i : l) {
        System.out.print(String.format("%d,",i));
      }
      System.out.print("]\n");
    }
  }
}
