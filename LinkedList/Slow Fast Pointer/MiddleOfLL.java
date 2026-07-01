
//Algorithm:
//1. Initialize two pointers, slow and fast, at the head.
//2. Move slow by one node and fast by two nodes.
//3. Repeat until fast == null or fast.next == null.
//4. When the loop ends, slow will be at the middle node.
//5. Return slow.
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
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}