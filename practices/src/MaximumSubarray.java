/**
 * Created by yuewenwang on 2017/8/25.
 */
public class MaximumSubarray
{
  public int maxSubArray(int[] nums) {
    int result = 0;
    int aggregater = 0;
    int minl = 0;
    int r = 0;
    while(r < nums.length) {
      aggregater += nums[r];
      result = r == 0 ? aggregater : Math.max(aggregater-minl, result);
      minl = Math.min(aggregater, minl);
      r ++;
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{-2};
    System.out.println(String.format("The maxi sum is %d", new MaximumSubarray().maxSubArray(nums)));
  }
}
