//1. Initialize two pointers: left at the head and right at the tail of the DLL.
//2. Traverse to the last node to position right.
//3. While left is before right:
//   a. Compute sum = left.data + right.data.
//   b. If sum == target, store the pair and move both pointers.
//   c. If sum < target, move left forward.
//   d. If sum > target, move right backward.
//4. Return the list of all found pairs.

/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Node left = head;
        Node right = head;

        while(right.next != null){
            right = right.next;
        }

        while(left.data < right.data){
            int sum = left.data + right.data;

            if(sum == target){
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(left.data);
                curr.add(right.data);
                result.add(curr);
                left = left.next;
                right = right.prev;
            }else if(sum < target){
                left = left.next;
            }else{
                right = right.prev;
            }
        }
        return result;
    }
}
