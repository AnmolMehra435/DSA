//1. If current string length == 2 * n
//      -> Store the string and return.
//
//2. If open < n
//      -> Add '('
//      -> Recurse with open + 1
//      -> Backtrack.
//
//3. If close < open
//      -> Add ')'
//      -> Recurse with close + 1
//      -> Backtrack.
//
//4. Repeat until all valid combinations are generated.

class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        solve(n, curr, 0, 0);
        return result;
    }

    private void solve(int n, StringBuilder curr, int open, int close){
        if(curr.length() == n*2){
            result.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append('(');
            solve(n, curr, open+1, close);
            curr.deleteCharAt(curr.length() - 1);
        }

        if(close < open){
            curr.append(')');
            solve(n, curr, open, close+1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}