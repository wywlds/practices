/**
 * Created by yuewenwang on 2017/8/31.
 */
public class RemoveDuplicatedFromSortedListII
{
  public static class ListNode
  {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
  }

  public ListNode deleteDuplicates(ListNode head) {
    ListNode cur = head;
    ListNode newCur = head;
    ListNode preCur = null;
    while(cur != null) {
      while(cur.next != null && cur.next.val == cur.val) {
        cur = cur.next;
      }
      if (cur.next == null || cur.next.val != cur.val) {
        newCur.val = cur.val;
        preCur = newCur;
        newCur = newCur.next;
        cur = cur.next;
      }
    }
    if (preCur == null) {
      return null;
    } else {
      preCur.next = null;
      return head;
    }

  }
}
