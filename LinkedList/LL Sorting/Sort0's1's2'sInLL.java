//1. Create three dummy nodes for 0s, 1s, and 2s.
//
//2. Traverse the linked list once.
//   - If node value is 0, attach it to the 0-list.
//   - If node value is 1, attach it to the 1-list.
//   - If node value is 2, attach it to the 2-list.
//
//3. Connect the three lists.
//   - Connect the 0-list to the 1-list (or directly to the 2-list if the 1-list is empty).
//   - Connect the 1-list to the 2-list.
//
//4. Set the last node of the 2-list to null.
//
//5. Return the head of the merged list (zeroes.next).

/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        // code here
        Node zeroes = new Node(0);
        Node ones = new Node(1);
        Node twos = new Node(2);

        Node temp1 = zeroes;
        Node temp2 = ones;
        Node temp3 = twos;

        Node temp = head;
        while(temp != null){
            int val = temp.data;

            if(val == 0){
                temp1.next = temp;
                temp1 = temp1.next;
            }else if(val == 1){
                temp2.next = temp;
                temp2 = temp2.next;
            }else{
                temp3.next = temp;
                temp3 = temp3.next;
            }
            temp = temp.next;
        }

        if(ones.next == null){
            temp1.next = twos.next;
        }else{
            temp1.next = ones.next;
            temp2.next = twos.next;
        }
        temp3.next = null;


        return zeroes.next;
    }
}