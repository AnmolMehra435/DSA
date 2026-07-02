//Algorithm:
//1. Reverse the linked list.
//2. Initialize carry = 1 and create a dummy node for the result.
//3. Traverse the reversed list while there are remaining nodes or carry is non-zero:
//   a. Set sum = carry.
//   b. If the current node exists, add its value to sum and move to the next node.
//   c. Create a new node with value = sum % 10 and append it to the result list.
//   d. Update carry = sum / 10.
//4. Reverse the result linked list.
//5. Return the head of the reversed result list.

/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node addOne(Node head) {
        // code here.

        Node newHead = reverse(head);
        Node dummy = new Node(0);
        Node curr = dummy;

        int carry = 1;

        while(newHead != null || carry != 0){
            int sum = carry;

            if(newHead != null){
                sum += newHead.data;
                newHead = newHead.next;
            }

            int num = sum % 10;
            carry = sum / 10;

            Node newNode = new Node(num);

            curr.next = newNode;
            curr = curr.next;
        }
        return reverse(dummy.next);
    }

    private Node reverse(Node head){
        Node curr = null;
        while(head != null){
            Node newNode = head.next;
            head.next = curr;
            curr = head;
            head = newNode;
        }

        return curr;
    }
}