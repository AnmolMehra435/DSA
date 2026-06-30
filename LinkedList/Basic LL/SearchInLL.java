//1. Start traversing the linked list from the head node.
//2. Compare each node's data with the given key.
//3. If a match is found, return `true`.
//4. Continue traversal until the end of the list.
//5. If the key is not found, return `false`.

/*
  class Node {
   int data;
    Node next;

    Node(int d)  { data = d;  next = null; }
}
*/
class Solution {
    public boolean searchKey(Node head, int key) {
        // Code here
        Node temp = head;

        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }

        return false;
    }
}