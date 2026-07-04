//1. Create a dummy node and point curr to it.
//2. Traverse the doubly linked list using temp.
//3. For each node:
//   a. If its value is not x:
//      - Link curr.next to temp.
//      - Set temp.prev = curr.
//      - Move curr to temp.
//   b. Move temp to the next node.
//4. Set curr.next = null to terminate the new list.
//5. If the new list is not empty, set dummy.next.prev = null.
//6. Return dummy.next as the new head.

/* Structure of Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        Node dummy = new Node(0);
        Node curr = dummy;
        Node temp = head;

        while(temp != null){
            if(temp.data != x){
                curr.next = temp;
                temp.prev = curr;
                curr = temp;
            }

            temp = temp.next;
        }

        curr.next = null;
        if(dummy.next != null){
            dummy.next.prev = null;
        }

        return dummy.next;
    }
}