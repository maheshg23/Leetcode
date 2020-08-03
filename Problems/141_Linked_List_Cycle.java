// 141. Linked List Cycle

// HashMap
public class Solution {
    public boolean hasCycle(ListNode head) {

        Set<ListNode> hs = new HashSet<>();
        while (head != null) {
            if (hs.contains(head)) {
                return true;
            }
            hs.add(head);
            head = head.next;
        }
        return false;
    }
}

// Two Pointers
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
            if (head == fast)
                return true;
        }
        return false;
    }
}

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */