//1. Initialize a counter variable to `0`.
//2. Traverse the linked list from the head node.
//3. Increment the counter for each node visited.
//4. Continue until the current node becomes `null`.
//5. Return the counter as the length of the linked list.


/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int a){
        data = a;
        next = null;
    }
}
*/
class Solution {
    public int getCount(Node head) {
        // code here
        int i = 0;
        Node temp = head;
        while(temp != null){
            i++;
            temp = temp.next;
        }

        return i;
    }
}