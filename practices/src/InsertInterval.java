import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuewenwang on 2017/8/25.
 */

public class InsertInterval
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

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> list = new ArrayList<>();
    list.add(newInterval);
    for (Interval interval : intervals) {
      if (interval.end < newInterval.start) {
        list.remove(newInterval);
        list.add(interval);
        list.add(newInterval);
      } else if (!(newInterval.end < interval.start)) {
        list.remove(newInterval);
        newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
        list.add(newInterval);
      } else {
        list.add(interval);
      }
    }
    return list;
  }
}
