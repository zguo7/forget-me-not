Problem Statement #
Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting
from the head.

If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.

Solution #
The problem follows the In-place Reversal of a LinkedList pattern and is quite similar to
Reverse a Sub-list. The only difference is that we have to reverse all the sub-lists. We
can use the same approach, starting with the first sub-list (i.e. p=1, q=k) and keep
reversing all the sublists of size ‘k’.

import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseEveryKElements {

  public static ListNode reverse(ListNode head, int k) {
    if (k <= 1 || head == null)
      return head;

    ListNode current = head, previous = null;
    while (true) {
      ListNode lastNodeOfPreviousPart = previous;
      // after reversing the LinkedList 'current' will become the last node of the sub-list to be reversed
      ListNode lastNodeOfSubList = current;
      ListNode next = null; // will be used to temporarily store the next node
      // reverse 'k' nodes
      for (int i = 0; current != null && i < k; i++) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
      }

      // connect with the previous part
      if (lastNodeOfPreviousPart != null)
        lastNodeOfPreviousPart.next = previous; // 'previous' is now the first node of the sub-list just reversed
      else // this means we are changing the first node (head) of the LinkedList
        head = previous;

      // connect with the next part
      lastNodeOfSubList.next = current;

      if (current == null) // break, if we've reached the end of the LinkedList
        break;
      // prepare for the next sub-list
      previous = lastNodeOfSubList;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}


Time complexity #
The time complexity of our algorithm will be O(N) where ‘N’ is the total number of
nodes in the LinkedList.

Space complexity #
We only used constant space, therefore, the space complexity of our algorithm is O(1).
