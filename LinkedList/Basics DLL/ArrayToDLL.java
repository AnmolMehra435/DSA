//1. Create the head node using the first element of the array and point `temp` to it.
//2. Traverse the array from index `1` to `n-1`.
//3. For each element, create a new node and connect it using:
//
//   * `temp.next = newNode`
//   * `newNode.prev = temp`
//4. Move `temp` to the newly created node.
//5. After the traversal is complete, return `head`.

/* class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
} */

class Solution {
    public Node createDLL(int arr[]) {
        // code here
        Node head = new Node(arr[0]);
        Node temp = head;


        for(int i = 1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;

            temp = newNode;
        }

        return head;
    }
}