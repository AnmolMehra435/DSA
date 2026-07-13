//1. If the stack is empty, return.
//
//2. Pop the top element.
//
//3. Recursively sort the remaining stack.
//
//4. Insert the popped element back into its correct position:
//   a. If the stack is empty OR the top element is less than or equal to the current element,
//      push the current element and return.
//   b. Otherwise:
//      - Pop the top element.
//      - Recursively insert the current element.
//      - Push the popped element back.
//
//5. After all recursive calls finish, the stack is sorted in ascending order
//   (smallest at the bottom, largest at the top).

class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()){
            return;
        }

        sort(st);
    }

    private void sort(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }

        int top = st.pop();

        sort(st);

        insert(top, st);
    }

    private void insert(int n, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(n);
            return;
        }

        int top = st.peek();

        if(n >= top){
            st.push(n);
            return;
        }

        int temp = st.pop();

        insert(n, st);

        st.push(temp);
    }
}