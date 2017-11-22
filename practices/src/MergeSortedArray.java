/**
 * Created by yuewenwang on 2017/10/16.
 */
public class MergeSortedArray
{
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int start = m + n - 1;
    m --;
    n --;
    while(m != -1 && n != -1) {
      if (nums2[n] > nums1[m]) {
        nums1[start--] = nums2[n--];
      } else {
        nums1[start--] = nums1[m--];
      }
    }
    while(n!=-1) {
      nums1[start --] = nums2[n--];
    }
  }

  public static void main(String[] String) {
    int[] nums1 = new int[13];
    nums1[0] = 1;
    nums1[1] = 3;
    nums1[2] = 5;
    nums1[3] = 7;
    nums1[4] = 9;
    int[] nums2 = new int[]{2,6,7,8,9,11,12,15};

    new MergeSortedArray().merge(nums1, 5, nums2, 8);
  }

}
