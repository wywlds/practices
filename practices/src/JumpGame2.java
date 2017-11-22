/**
 * Created by yuewenwang on 2017/8/25.
 */
public class JumpGame2
{
  public boolean canJump(int[] nums) {
    int lastindex = 0;
    int i = 0;
    while(i <= lastindex) {
      lastindex = Math.max(i + nums[i], lastindex);
      i ++;
      if (lastindex >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3,2,1,1,4};
    nums = new int[]{3,2,1,0,4};
    System.out.println(new JumpGame2().canJump(nums));
  }
}
