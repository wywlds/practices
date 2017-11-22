import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yuewenwang on 2017/8/25.
 */
public class MergeIntervals
{
  public static class Interval
  {
    int start;
    int end;

    Interval()
    {
      start = 0;
      end = 0;
    }

    Interval(int s, int e)
    {
      start = s;
      end = e;
    }

    @Override
    public String toString()
    {
      return String.format("[%d, %d]", start, end);
    }
  }

  public List<Interval> merge(List<Interval> intervals)
  {
    List<Interval> result = new ArrayList<>();
    if (intervals.size() == 0) {
      return result;
    }
    List<Integer> startList = new ArrayList<>();
    List<Integer> endList = new ArrayList<>();
    for (Interval it : intervals) {
      startList.add(it.start);
      endList.add(it.end);
    }
    startList.sort(new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o1.intValue() - o2.intValue();
      }
    });
    endList.sort(new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        return o1.intValue() - o2.intValue();
      }
    });
    int start = 0;
    int ps = 0;
    int pe = 0;
    int numstart = 0;
    while (true) {
      if (startList.get(ps) <= endList.get(pe)) {
        if (numstart == 0) {
          start = startList.get(ps);
        }
        ps ++;
        numstart ++;
      } else {
        numstart --;
        if (numstart == 0) {
          result.add(new Interval(start, endList.get(pe)));
        }
        pe ++;
      }
      if (ps == startList.size()) {
        result.add(new Interval(start, endList.get(endList.size() - 1)));
        break;
      }
    }

    return result;
  }

  public static void main(String[] args)
  {
    List<Interval> intervals = new ArrayList<>();
    intervals.add(new Interval(2, 3));
    intervals.add(new Interval(5, 5));
    intervals.add(new Interval(2, 2));
    intervals.add(new Interval(3, 4));
    intervals.add(new Interval(3, 4));

    System.out.print(new MergeIntervals().merge(intervals));
  }
}
