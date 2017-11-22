import java.util.Stack;

/**
 * Created by yuewenwang on 2017/8/31.
 */
public class MaximumRectangle
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

  public int maximalRectangle(char[][] matrix) {
    int m = matrix.length;
    int n = m!=0 ? matrix[0].length:0;
    int[][] count = new int[n][];
    for (int i = 0 ; i < n ; i ++) {
      count[i] = new int[m];
    }
    for (int i = 0 ; i < m ; i ++) {
      for (int j = 0 ; j < n ; j ++) {
        if (matrix[i][j] == '0') {
          count[j][i] = 0;
        } else {
          count[j][i] = j == 0 ? 1 : count[j - 1][i] + 1;
        }
      }
    }
    int max = 0;
    for (int i = 0 ; i < n ; i ++) {
      max = Math.max(max, largestRectangleArea(count[i]));
    }
    return max;
  }
//      1 0 1 0 0
//      1 0 1 1 1
//      1 1 1 1 1
//      1 0 0 1 0
  public static void main(String[] args) {
    char[][] matrix = new char[4][];
    matrix[0] = new char[]{'1', '0', '1', '0', '0'};
    matrix[1] = new char[]{'1', '0', '1', '1', '1'};
    matrix[2] = new char[]{'1', '1', '1', '1', '1'};
    matrix[3] = new char[]{'1', '0', '0', '1', '0'};
    System.out.print(new MaximumRectangle().maximalRectangle(matrix));
  }
}
