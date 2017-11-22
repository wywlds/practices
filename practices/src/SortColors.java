/**
 * Created by yuewenwang on 2017/8/29.
 */
public class SortColors
{
  public void sortColors(int[] nums) {
    int p0 = 0;
    int p1 = 0;
    int p2 = 0;
    for (int i = 0 ; i < nums.length ; i ++) {
      if (nums[i] == 0) {
        nums[p0] = 0;
        if (p1 != 0) {
          nums[p0 + p1] = 1;
        }
        if (p2 != 0) {
          nums[p0 + p1 + p2] = 2;
        }
        p0 ++;
      } else if (nums[i] == 1) {
        nums[p0+p1] = 1;
        if (p2 != 0) {
          nums[p0 + p1 + p2] = 2;
        }
        p1 ++;
      } else {
        p2 ++;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{0,1,2,1,2,0,2,0};
    new SortColors().sortColors(nums);
    for (int num : nums) {
      System.out.println(num);
    }
  }

}
