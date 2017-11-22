/**
 * Created by yuewenwang on 2017/8/30.
 */
public class WordSearch
{
  public boolean exist(char[][] board, String word) {
    int m = board.length;
    if (m == 0) {
      return false;
    }
    int n = board[0].length;
    for (int i = 0 ; i < m ; i ++) {
      for (int j = 0 ; j < n; j ++) {
        if (existInternal(board, word, i, j, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean existInternal(char[][] board, String word, int i, int j, int index) {
    if (index == word.length()) {
      return true;
    }
    char cur = word.charAt(index);
    if (i < 0 || i == board.length || j < 0 || j == board[0].length) {
      return false;
    }
    if (cur != board[i][j]) {
      return false;
    }
    board[i][j] = 0;
    boolean isExist = existInternal(board,word, i - 1, j, index + 1) ||
                      existInternal(board,word,i,j-1,index + 1) ||
                      existInternal(board,word, i+ 1, j, index + 1) ||
                      existInternal(board, word, i,j + 1, index + 1);
    board[i][j]=cur;
    return isExist;
  }

  public static void main(String[] args) {
    WordSearch ws = new WordSearch();
    char[][] board = new char[1][];
    board[0] = new char[]{'a', 'b'};
    System.out.println(ws.exist(board, "ba"));
  }
}
