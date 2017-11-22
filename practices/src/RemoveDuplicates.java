/**
 * Created by yuewenwang on 2017/8/30.
 * @author yuewenwang
 */
public class RemoveDuplicates
{
  public int removeDuplicates(int[] nums) {
    int p1 = 0;
    int p2 = 0;
    while(p2!=nums.length && p1 != nums.length) {
      if (p1 == nums.length - 1) {
        nums[p2] = nums[p1];
        p2 ++;
        break;
      } else {
        int tmp = nums[p1];
        if (nums[p1 + 1] == tmp) {
          nums[p2] = tmp;
          nums[p2 + 1] = tmp;
          p2 = p2 +2;
          while (p1<nums.length-1 &&nums[++p1] == tmp){}
        } else {
          nums[p2 ++] = tmp;
          p1 ++;
        }
      }
    }
    return p2;
  }
  public static void main(String[] args) {
    int[] nums = new int[]{1,1,1,1,1,2,3,3,3,4,4,5};
    nums = new int[]{1,1};
    int length = new RemoveDuplicates().removeDuplicates(nums);
    for (int i = 0 ; i < length ; i ++) {
      System.out.print(String.format("%d,", nums[i]));
    }
  }
}
