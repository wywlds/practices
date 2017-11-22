/**
 * Created by yuewenwang on 2017/9/13.
 */
public class QuickSort
{
    public final static int THRESHOLD = 10;
    public void swap(int[] list, int left, int right) {
      int tmp = list[left];
      list[left] = list[right];
      list[right] = tmp;
    }
    public int findMedian(int[] list, int left, int right) {
      int mid = (left + right) / 2;
      if (list[left] > list[mid]) {
        swap(list, left, mid);
      }
      if (list[mid] > list[right]) {
        swap(list, mid, right);
      }
      if (list[left] > list[mid]) {
        swap(list, left, mid);
      }
      swap(list, mid, right - 1);
      return list[mid];
    }
    public void insertSort(int[] list, int left, int right) {
      for (int i = left; i < right ; i ++) {
        int minimum = Integer.MAX_VALUE;
        int p = i;
        for (int j = i ; j <= right ; j ++) {
          if (list[j] < minimum){
            minimum = list[j];
            p = j;
          }
        }
        swap(list, i , p);
      }
    }
    public void sort(int[] list, int left, int right) {
      if (right - left < THRESHOLD) {
        insertSort(list, left, right);//当right和left的差值小于一个比较小的值时，由于插入排序的效率也不差，所以用插入排序，避免很多边界条件的麻烦
        return;
      }
      int pivot = findMedian(list, left, right);//意思是找到left，right还有（left+right）／2之中中间的那个值，并且把中间那个值放到right - 1,返回中间值
      int i = left;
      int j = right - 1;
      while(true) {
        while(list[++i]<pivot);
        while(list[--j]>pivot);
        if (i < j) {
          swap(list, i, j);
        } else {
          break;
        }
      }
      swap(list, right - 1, i);
      sort(list, left + 1, i - 1);
      sort(list, right - 1, i + 1);
    }
    public static void main(String[] args) {
      QuickSort p = new QuickSort();
      int[] list = new int[]{2,3,41,5,2,4435,234,56,12,4};
      p.sort(list, 0, list.length - 1);
      for (int i : list) {
        System.out.println(i);
      }
    }
}
