//1. Traverse the doubly linked list up to the given position `p`.
//2. Create a new node with the value `x`.
//3. If the insertion position is at the end, link the new node after the current node and update its `prev` pointer.
//4. Otherwise, store the next node, insert the new node between the current node and the next node, and update both `next` and `prev` pointers.
//5. Return the head of the doubly linked list.

/*
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/

class Solution {
    Node insertAtPos(Node head, int p, int x) {
        // code here
        int i = 0;
        Node temp = head;

        while(i<p){
            temp = temp.next;
            i++;
        }

        Node newNode = new Node(x);

        if(temp.next == null){
            temp.next = newNode;
            newNode.prev = temp;
        }else{
            Node tempNode = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = tempNode;
            tempNode.prev = newNode;
        }

        return head;

    }
}