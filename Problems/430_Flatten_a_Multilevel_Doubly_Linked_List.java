/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// 0ms Less Space
class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return null;

        Node node = new Node();
        Node root = head;
        while (head.next != null || head.child != null) {
            if (head.child != null) {
                node = traverse(head.child);
                node.next = head.next;
                if (node.next != null) {
                    node.next.prev = node;
                }
                head.next = head.child;
                if (head.next != null) {
                    head.next.prev = head;
                }
                head.child = null;
            }
            head = head.next;
        }
        return root;
    }

    public Node traverse(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}

// More Space
class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return null;

        Node node = new Node();
        Node root = head;
        while (head.next != null || head.child != null) {
            if (head.child != null) {
                // Traverse the child to find the last node of the child
                node = head.child;
                while (node.next != null) {
                    node = node.next;
                }
                // Node is the last node of the child and then rearrange the pointers
                node.next = head.next;
                if (node.next != null) {
                    node.next.prev = node;
                }
                head.next = head.child;
                if (head.next != null) {
                    head.next.prev = head;
                }
                head.child = null;
            }
            head = head.next;
        }
        return root;
    }

}