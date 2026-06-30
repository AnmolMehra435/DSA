//1. Traverse the doubly linked list from the head node.
//2. For each node, swap its `next` and `prev` pointers.
//3. Move to the next node using the updated `prev` pointer (which was originally `next`).
//4. After the traversal, update the head to the original last node.
//5. Return the new head of the reversed doubly linked list.

/* Structure of doubly linked list node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        Node curr = head;
        Node temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }
}