//Algorithm:
//1. If the list is empty or k = 1, return the head.
//2. Create a dummy node and point it to the head.
//3. Initialize prevGroup to the dummy node.
//4. Find the kth node from prevGroup.
//5. If the kth node does not exist, stop and return the list.
//6. Store the next group's starting node.
//7. Reverse the current group of k nodes.
//8. Connect the reversed group with the previous and next groups.
//9. Move prevGroup to the tail of the reversed group.
//10. Repeat until fewer than k nodes remain.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevNode = dummy;

        while(true){
            ListNode kth = findKthNode(prevNode, k);

            if(kth == null){
                break;
            }

            ListNode nextNode = kth.next;

            ListNode prev = nextNode;
            ListNode curr = prevNode.next;

            while(curr != nextNode){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            ListNode temp = prevNode.next;
            prevNode.next = kth;
            prevNode = temp;
        }
        return dummy.next;
    }

    private ListNode findKthNode(ListNode prevNode, int k){
        ListNode temp = prevNode;
        int i = 0;
        while(i<k && temp != null){
            i++;
            temp = temp.next;
        }
        return temp;
    }
}