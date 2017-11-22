import java.util.Stack;

/**
 * Created by yuewenwang on 2017/8/31.
 */
public class LargestRectangleArea
{
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    int max = 0;
    while(i < heights.length) {
      if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
        stack.push(i);
        i ++;
      } else {
        int top = stack.pop();
        int left = stack.isEmpty()? -1 : stack.peek();
        int width = i - left - 1;
        max = Math.max(max, heights[top] * width);
      }
    }
    while (!stack.isEmpty()) {
      int top = stack.pop();
      int left = stack.isEmpty()? -1 : stack.peek();
      int width = i - left - 1;
      max = Math.max(max, heights[top] * width);
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.print(new LargestRectangleArea().largestRectangleArea(new int[]{1,0,1,0,1}));
  }
}
