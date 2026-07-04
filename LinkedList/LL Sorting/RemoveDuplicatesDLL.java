//Algorithm:
//1. If the list is empty or has only one node, return head.
//2. Initialize curr = head.
//3. Traverse the list while curr != null and curr.next != null.
//4. If curr.data == curr.next.data:
//   a. Store duplicate = curr.next.
//   b. Set curr.next = duplicate.next.
//   c. If duplicate.next != null, set duplicate.next.prev = curr.
//5. Otherwise, move curr = curr.next.
//6. Return head.

/* Structure of a link list node
class Node {
    int data;  // value stored in node
    Node next;
    Node prev;

    Node(int value) {
        data = value;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    Node removeDuplicates(Node headRef) {
        // code here
        if(headRef == null || headRef.next == null){
            return headRef;
        }
        Node curr = headRef;
        while(curr != null && curr.next != null){
            if(curr.data == curr.next.data){
                Node duplicate = curr.next;
                curr.next = duplicate.next;
                if(duplicate.next != null){
                    duplicate.next.prev = curr;
                }
            }else{
                curr = curr.next;
            }
        }
        return headRef;
    }
}