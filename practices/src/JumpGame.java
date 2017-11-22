/**
 * Created by yuewenwang on 2017/8/23.
 */
public class JumpGame
{
  public int jump(int[] nums) {
    return jumpInternal(nums, 0);
  }

  public int jumpInternal(int[] nums, int index) {
    if (index == nums.length - 1) {
      return 0;
    }
    int threshold = nums[index];
    if (index + threshold >= nums.length - 1) {
      return 1;
    }
    int result = Integer.MAX_VALUE;
    for (int i = 1; i <= threshold ; i ++) {
      if (nums[index + i] == 0) {
        continue;
      }
      int subResult = jumpInternal(nums, index + i);
      if (subResult == Integer.MAX_VALUE) {
        continue;
      }
      result = Math.min(result, 1 + subResult);
      if (result == 2) {
        break;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
    System.out.println(String.format("num:%d", new JumpGame().jump(nums)));
  }
}
