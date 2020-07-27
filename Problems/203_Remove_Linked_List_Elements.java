// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/
// 203. Remove Linked List Elements

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null && temp.val == val) {
            head = temp.next;
            temp = head;
        }
        while (temp != null) {
            while (temp != null && temp.val != val) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null)
                return head;
            prev.next = temp.next;
            temp = prev.next;
        }
        return head;
    }
}

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                pre.next = node.next;
                node = node.next;
            } else {
                pre = pre.next;
                node = node.next;
            }
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */