//Algorithm:
//1. Initialize two pointers, slow and fast, at the head.
//2. Move slow by one node and fast by two nodes.
//3. After each move, check if slow == fast.
//4. If they meet, a cycle exists, so return true.
//5. If fast reaches null or fast.next becomes null, no cycle exists.
//6. Return false.
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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}