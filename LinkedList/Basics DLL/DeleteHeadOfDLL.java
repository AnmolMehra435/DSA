//1. Check if the doubly linked list is empty. If yes, return `head`.
//2. Store `head.next` in a temporary node.
//3. Update the temporary node's `prev` pointer to `null`.
//4. Disconnect the current head node from the list.
//5. Return the temporary node as the new head.

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        this.next = this.prev = null;
    }
}
*/

// Complete the function
class Solution {
    public static Node deleteHead(Node head) {
        // your code here
        if(head == null){
            return head;
        }

        Node temp = head.next;
        temp.prev = null;
        head.next = null;

        return temp;
    }
}