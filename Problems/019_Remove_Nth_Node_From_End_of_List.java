// 19. Remove Nth Node From End of List

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0)
            return head;
        ListNode example = new ListNode(0);
        example.next = head;
        ListNode first = example;
        ListNode second = example;
        for (int i = 0; i <= n; i++) {
            if (first != null) {
                first = first.next;
            }
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return example.next;
    }
}
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */