import java.util.ArrayList;

/**
 * Created by yuewenwang on 2017/8/31.
 */
public class PartitionList
{
  public static class ListNode
  {
    int val;
    ListNode next;

    ListNode(int x) { val = x; }
  }

  public void addNode(ListNode[] startNodes, ListNode[] endNodes, int i, ListNode added) {
    if (startNodes[i] == null) {
      startNodes[i] = added;
      endNodes[i] = added;
    } else {
      endNodes[i].next = added;
      endNodes[i] = added;
    }
  }
  public ListNode partition(ListNode head, int x) {
    ListNode[] startNodes = new ListNode[2];
    ListNode[] endNodes = new ListNode[2];
    while(head != null) {
      if (head.val >= x) {
        addNode(startNodes, endNodes, 1, head);
      }  {
        addNode(startNodes, endNodes, 0, head);
      }
      head = head.next;
    }

    return combineNodes(startNodes, endNodes);
  }

  private ListNode combineNodes(ListNode[] startNodes, ListNode[] endNodes)
  {
    ListNode head = null;
    int pos = 0;
    for (int i = 0 ; i < startNodes.length ; i ++) {
      if (startNodes[i] != null) {
        head = startNodes[i];
        pos = i;
        break;
      }
    }
    if (head == null) {
      return null;
    }
    ListNode lastEnd = endNodes[pos];
    for (int i = pos + 1 ; i < startNodes.length ; i ++) {
      if (startNodes[i] != null) {
        lastEnd.next = startNodes[i];
        lastEnd = endNodes[i];
      }
    }
    lastEnd.next = null;
    return head;
  }

  public static void main(String[] args) {
    //ListNode node0 = new ListNode(0);
    ListNode node1 = new ListNode(1);
    //ListNode node2 = new ListNode(2);
    //ListNode node3 = new ListNode(3);
    //ListNode node4 = new ListNode(4);
    //ListNode node5 = new ListNode(5);

    //node0.next = node1;
//    node1.next = node5;
//    node5.next = node2;
//    node2.next = node4;
//    node4.next = node3;
    ListNode node = new PartitionList().partition(node1, 2);
    while(node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }

}
