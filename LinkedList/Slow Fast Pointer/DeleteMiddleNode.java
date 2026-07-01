//Algorithm:
//1. If the list has 0 or 1 node, return null.
//2. Initialize slow at the head and fast two nodes ahead.
//3. Move slow by one node and fast by two nodes until fast reaches the end.
//4. Slow will be at the node before the middle.
//5. Delete the middle node by updating slow.next to slow.next.next.
//6. Return the head.
//
//Time Complexity: O(n)
//Space Complexity: O(1)

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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;
        return head;
    }
}