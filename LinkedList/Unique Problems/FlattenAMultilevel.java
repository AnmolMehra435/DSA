//flatten(head):
//1. Call dfs(head) and return head.
//
//dfs(node):
//1. Initialize curr = node and last = null.
//2. While curr is not null:
//   a. Save next = curr.next.
//   b. If curr has a child:
//      - Flatten the child list and get its tail.
//      - Connect curr ↔ child.
//      - Set curr.child = null.
//      - Connect childTail ↔ saved next (if it exists).
//      - Update last = childTail.
//   c. Otherwise, update last = curr.
//   d. Move curr = next.
//3. Return last (tail of the flattened list).


class Solution {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = dfs(childHead);

                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}