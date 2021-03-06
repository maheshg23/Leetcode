// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3290/
// 876. Middle of the Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode node = head;
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        int i = 0;
        int n = count / 2;
        while (i < n) {
            i++;
            node = node.next;
        }
        return node;
    }
}

// Slow fast pointer
class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}