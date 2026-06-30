//1. Create a new node with the given value `x`.
//2. Point the new node's `next` to the current head.
//3. Update the head to the new node.
//4. Return the new head.

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node insertAtFront(Node head, int x) {
        // code here
        if(head == null){
            return new Node(x);
        }

        Node newNode = new Node(x);

        newNode.next = head;

        return newNode;
    }
}