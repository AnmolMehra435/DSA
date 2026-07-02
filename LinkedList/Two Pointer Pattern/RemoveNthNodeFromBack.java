//Algorithm:
//1. Create a dummy node pointing to the head.
//2. Initialize fast at the head and slow at the dummy node.
//3. Move the fast pointer n steps ahead.
//4. Move both fast and slow one step at a time until fast reaches the end.
//5. Delete the node after slow by updating slow.next = slow.next.next.
//6. Return dummy.next as the new head.


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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 0; i<n; i++){
            fast = fast.next;
        }

        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode nextNode = slow.next;
        slow.next = slow.next.next;
        nextNode = null;

        return dummy.next;

    }
}