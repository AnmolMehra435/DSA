//Algorithm:
//1. Initialize two pointers p1 = headA and p2 = headB.
//2. Traverse both lists simultaneously.
//3. If p1 becomes null, move it to headB; otherwise, move it to the next node.
//4. If p2 becomes null, move it to headA; otherwise, move it to the next node.
//5. Continue until p1 == p2.
//6. Return p1 (intersection node if found, otherwise null).

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2){
            p1 = (p1 == null)? headB: p1.next;
            p2 = (p2 == null)? headA: p2.next;
        }

        return p1;
    }
}