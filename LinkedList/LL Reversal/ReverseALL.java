//Algorithm:
//1. If the list is empty or has one node, return the head.
//2. Initialize curr as null and temp as the head.
//3. Store the next node of temp.
//4. Reverse the current node's link by pointing it to curr.
//5. Move curr to temp and temp to the stored next node.
//6. Repeat until temp becomes null.
//7. Return curr as the new head.
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode curr = null;
        while(temp != null){
            ListNode nextNode = temp.next;
            temp.next = curr;
            curr = temp;
            temp = nextNode;
        }
        return curr;
    }
}