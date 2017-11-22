import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuewenwang on 2017/9/1.
 */
public class MaximumSelection
{
  public static class Video {
    public boolean isAvalaible;
    public int rate;
    public int startTime;
    public boolean isContradictory(Video right) {
      return (startTime + 4) % 24 >= right.startTime || (right.startTime + 4) % 24 >= startTime;
    }
  }

  //假定video有10个
  public ArrayList<Video> maxSelection(Video[] videos) {
    //使用一个数组来存储最大可能的值，它的index是从1到1023的正数，二进制的每一位对应着这一位有没有被选中
    int[] maxResult = new int[1024];
    //初始化，如果没有任何video被选中，那么是0
    maxResult[0] = 0;
    for (int s = 0 ; s < 1024 ; s ++) {
      //标记为-1，如果没有改变的话，-1表示这种情况不成立！
      maxResult[s] = -1;
      for (int i = 0 ; i < 10 ; i ++) {
        /** 这种状态肯定是比它少1个的那种状态演变而来
         第一种情况：如果i的位置比s要大，那么i肯定不在s中
         而且比i大的也肯定不在s中,停止循环
        */
        if(s - (1<<i) < 0) {
          break;
        }
        /**
         * 第二种情况，i在s中，且去掉i后s的最大rate和不等于-1，表示去掉i后的s互相不互斥
         */
        if (((s & (1<<i)) != 0) && maxResult[s - (1<<i)] != -1 ) {
          //那么我们首先判断i是否和去掉i的s互斥
          boolean isContradictory = false;
          for (int j = 0 ; j < 10 ; j ++) {
            if ((s & (1<<j)) != 0 && j != i) {
              isContradictory = isContradictory || videos[i].isContradictory(videos[j]);
            }
          }
          //如果不互斥的话，那么恭喜可以计算最大值了,而且只要能对上，那么肯定算出来的是正确结果
          if (!isContradictory) {
            maxResult[s] = maxResult[s - (1<<i)] + videos[i].rate;
            break;
          }
        }
      }
    }
    //找到列表中的最大值以及它对应的位置
    int max = 0;
    int index = 0;
    for (int i = 1 ; i < 1024 ; i ++) {
      if (max<maxResult[i]) {
        max = maxResult[i];
        index = i;
      }
    }
    //根据位置s反推是哪几个的位置的结合
    ArrayList<Video> result = new ArrayList<>(10);
    for (int i = 0 ; i < 10 ; i ++) {
      if (((1<<i) & index) != 0) {
        result.add(videos[i]);
      }
    }
    return result;
  }
}
