//1. Create a dummy node and point curr to it.
//2. Initialize carry = 0.
//3. Traverse both linked lists while either list has nodes or carry exists:
//   a. Set sum = carry.
//   b. If l1 has a node, add its value to sum and move l1 ahead.
//   c. If l2 has a node, add its value to sum and move l2 ahead.
//   d. Create a new node with value (sum % 10) and attach it to the result.
//   e. Update carry = sum / 10.
//   f. Move curr to the newly created node.
//4. Return dummy.next as the head of the resultant linked list.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        ListNode t1 = l1;
        ListNode t2 = l2;

        while(t1 != null || t2 != null || carry > 0){
            int sum = carry;
            if(t1 != null){
                sum += t1.val;
                t1 = t1.next;
            }

            if(t2 != null){
                sum += t2.val;
                t2 = t2.next;
            }


            int num = sum % 10;
            carry = sum / 10;

            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;
    }
}