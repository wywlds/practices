/**
 * Created by yuewenwang on 2017/8/30.
 */
public class SearchInSortedArray
{
  public static int THRESHOLD = 5;
  public boolean search(int[] nums, int target) {
    return searchInterval(nums, 0, nums.length - 1, target);
  }
  public boolean searchInterval(int[] nums, int start, int end, int target) {
    while(true) {
      if (end - start < THRESHOLD) {
        for (int i = start; i <= end ; i ++) {
          if (nums[i] == target) {
            return true;
          }
        }
        return false;
      }

      int middle = (start + end) / 2;
      if (nums[middle] > target) {
        if (nums[middle] < nums[start]) {
          return searchInterval(nums, start, middle -1, target);
        } else {
          return searchInterval(nums, start, middle - 1, target) || searchInterval(nums, middle + 1, end, target);
        }
      } else if (nums[middle] < target) {
        if (nums[middle] > nums[end]) {
          return searchInterval(nums, middle + 1, end, target);
        } else {
          return searchInterval(nums, start, middle - 1, target) || searchInterval(nums, middle + 1, end, target);
        }
      } else {
        return true;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{6,6,7,7,7,7,7,8,8,9,10,0,1,2,3,3,3,3,3,3,4,5,6};
    for (int i = 0 ; i < 12 ; i ++) {
      System.out.println(String.format("%d:%s", i, new SearchInSortedArray().search(nums, i)));
    }
  }
}
