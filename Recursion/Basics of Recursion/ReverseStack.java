//1. If the stack is empty, return.
//
//2. Pop the top element.
//
//3. Recursively reverse the remaining stack.
//
//4. Insert the popped element at the bottom:
//   a. If the stack is empty, push the element and return.
//   b. Otherwise:
//      - Pop the top element.
//      - Recursively insert the element at the bottom.
//      - Push the popped element back.
//
//5. After all recursive calls finish, the stack is reversed.

class Solution {
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){
            return;
        }

        int top = st.pop();

        reverseStack(st);

        insertAtBottom(top, st);
    }

    public static void insertAtBottom(int n, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(n);
            return;
        }

        int temp = st.pop();

        insertAtBottom(n, st);

        st.push(temp);
    }
}
