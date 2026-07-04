//Algorithm:
//1. If the list is empty, return null.
//2. Traverse the list to find its length (n) and the last node.
//3. Compute k = k % n. If k == 0, return the head.
//4. Connect the last node to the head to make the list circular.
//5. Move (n - k - 1) steps from the head to reach the new tail.
//6. The next node becomes the new head.
//7. Break the circular link by setting newTail.next = null.
//8. Return the new head.
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int n = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }

        k = k % n;
        if(k == 0){
            return head;
        }

        temp.next = head;
        temp = head;

        for(int i = 0; i<n-k-1; i++){
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}