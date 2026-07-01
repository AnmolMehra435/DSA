//Algorithm:
//1. Initialize two pointers, slow and fast, at the head.
//2. Move slow by one node and fast by two nodes.
//3. If slow and fast meet, initialize entry at the head.
//4. Move both entry and slow one step at a time.
//5. The node where they meet is the starting node of the cycle.
//6. If fast reaches null or fast.next becomes null, return null.
//
//Time Complexity: O(n)
//Space Complexity: O(1)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                ListNode entry = head;
                while(slow != entry){
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }
}