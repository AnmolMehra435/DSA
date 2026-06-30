//1. Check if the linked list is empty. If yes, return `head`.
//2. Store `head.next` in a temporary node.
//3. Disconnect the current head node from the list.
//4. Return the temporary node as the new head.
/*
class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = next;
    }
}
*/

class Solution {
    public Node deleteHead(Node head) {
        // code here
        if(head == null){
            return head;
        }

        Node temp = head.next;
        head.next = null;

        return temp;
    }
}