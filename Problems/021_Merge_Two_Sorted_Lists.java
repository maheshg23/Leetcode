// 21. Merge Two Sorted Lists

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode result = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                // System.out.println(l1.val);
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            } else {
                // System.out.println(l2.val);
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            // System.out.println(l1.val);
            res.next = new ListNode(l1.val);
            res = res.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            // System.out.println(l2.val);
            res.next = new ListNode(l2.val);
            res = res.next;
            l2 = l2.next;
        }
        return result.next;
    }
}

// Iterative Optimized
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode res = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                // System.out.println(l1.val);
                res.next = l1;
                l1 = l1.next;
            } else {
                // System.out.println(l2.val);
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        if (l1 == null) {
            res.next = l2;
        }
        if (l2 == null) {
            res.next = l1;
        }
        return result.next;
    }
}

// Recursion
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
