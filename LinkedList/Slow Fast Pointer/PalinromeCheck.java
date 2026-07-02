//Algorithm:
//1. Find the middle of the linked list using slow and fast pointers.
//2. Split the list into two halves.
//3. Reverse the second half of the linked list.
//4. Compare the nodes of the first half and the reversed second half.
//5. If any values differ, return false.
//6. If all values match, return true.

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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        ListNode rev = reverse(next);

        while(head != null && rev != null){
            if(head.val != rev.val){
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode curr = null;
        while(head != null){
            ListNode next = head.next;
            head.next = curr;
            curr = head;
            head = next;
        }
        return curr;
    }
}