//Algorithm:
//1. If the list is empty or has only one node, return the head.
//2. Initialize three pointers:
//   - odd = head
//   - even = head.next
//   - evenHead = even
//3. While even != null and even.next != null:
//   - Link odd to the next odd node.
//   - Move odd one step forward.
//   - Link even to the next even node.
//   - Move even one step forward.
//4. Connect the last odd node to evenHead.
//5. Return the head.
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}