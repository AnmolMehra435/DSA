//Algorithm:
//1. Initialize two pointers, slow and fast, at the head.
//2. Move slow by one node and fast by two nodes.
//3. If slow and fast meet, a cycle exists.
//4. Move one pointer around the cycle until it reaches the meeting point again, counting the nodes.
//5. Return the count as the length of the loop.
//6. If no cycle is found, return 0.
//
//Time Complexity: O(n)
//Space Complexity: O(1)

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                fast = fast.next;
                int i = 1;
                while(fast != slow){
                    fast = fast.next;
                    i++;
                }

                return i;
            }
        }
        return 0;
    }
}