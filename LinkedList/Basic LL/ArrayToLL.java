//1. Create the head node using the first element of the array and point `temp` to it.
//2. Traverse the array from index `1` to `n-1`.
//3. For each element, create a new node, attach it to `temp.next`, and move `temp` to the newly created node.
//4. After the traversal is complete, return `head`.

/*
// Representation of a node
class Node {
    int data;
    Node next;
    Node (int d) {
       data = d;
       next = null;
    }
};
*/
class Solution {
    public Node arrayToList(int arr[]) {
        // code here
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1; i<arr.length; i++){
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return head;
    }
}
