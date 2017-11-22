import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yuewenwang on 2017/8/24.
 */
public class UniquePermutations
{
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> backup = new ArrayList<Integer>(nums.length);
    for (int num : nums) {
      backup.add(new Integer(num));
    }
    permute(result, new ArrayList<>(), backup);
    return result;
  }

  public void permute(List<List<Integer>> container, List<Integer> prefix, List<Integer> backup) {
    if (backup.size() == 1) {
      prefix.add(backup.get(0));
      container.add(prefix);
      return;
    }

    HashSet<Integer> set = new HashSet<>();

    for (Integer it : backup) {
      if (set.contains(it)) {
        continue;
      }
      set.add(it);
      List<Integer> newPrefix = new ArrayList<>(prefix);
      newPrefix.add(it);
      List<Integer> newBackup = new ArrayList<>(backup);
      newBackup.remove(it);
      permute(container, newPrefix, newBackup);
    }
  }
  public static void main(String[] args) {
    System.out.println(new UniquePermutations().permuteUnique(new int[]{1,1,3}));
  }
}
