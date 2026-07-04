//1. If the list is empty or has only one node, return the head.
//
//2. Initialize:
//   - curr = head (last unique node)
//   - temp = head.next (traversal pointer)
//
//3. Traverse the list:
//   - If temp.data == curr.data, move temp to the next node.
//   - Otherwise, link curr.next to temp, move curr to temp, and advance temp.
//
//4. After traversal, set curr.next = null to remove any remaining duplicate links.
//
//5. Return the head of the modified linked list.

/* Structure of linked list Node
class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        // code here
        Node temp = head.next;
        Node curr = head;

        while(temp != null){
            if(temp.data == curr.data){
                temp = temp.next;
                continue;
            }

            curr.next = temp;
            curr = curr.next;
            temp = temp.next;
        }
        curr.next = null;

        return head;
    }
}