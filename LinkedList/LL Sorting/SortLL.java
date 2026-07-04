//1. If the list has 0 or 1 node, return it (already sorted).
//
//2. Find the middle of the linked list using slow and fast pointers.
//   - slow = head
//   - fast = head.next
//
//3. Split the list into two halves.
//   - second = slow.next
//   - slow.next = null
//
//4. Recursively sort both halves.
//   - left = sortList(head)
//   - right = sortList(second)
//
//5. Merge the two sorted halves.
//   - Compare nodes from both lists.
//   - Attach the smaller node to the result.
//   - Move the corresponding pointer.
//   - Append any remaining nodes.
//
//6. Return the merged sorted list.


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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(second);

        return mergeSort(left, right);
    }
    public ListNode mergeSort(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(left != null && right != null){
            if(left.val < right.val){
                temp.next = left;
                left = left.next;
            }else{
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}