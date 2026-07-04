//1. Create a HashMap to store (original node → copied node).
//2. Traverse the list and create a copy of each node, storing it in the map.
//3. Traverse the list again:
//   a. Set copy.next = map.get(original.next).
//   b. Set copy.random = map.get(original.random).
//4. Return map.get(head) as the head of the copied list.

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr!= null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}