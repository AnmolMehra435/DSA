//1. If current string length == n
//      -> Store the string and return.
//
//2. Append '0'.
//      -> Recurse.
//      -> Backtrack by removing the last character.
//
//3. Append '1'.
//      -> Recurse.
//      -> Backtrack by removing the last character.
//
//4. Return the list of all generated strings.

class Solution {
    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> binstr(int n) {
        // code here
        StringBuilder curr = new StringBuilder();

        solve(n, curr);
        return result;
    }

    private void solve(int n, StringBuilder curr){
        if(curr.length() == n){
            result.add(curr.toString());
            return;
        }

        curr.append('0');
        solve(n, curr);
        curr.deleteCharAt(curr.length() - 1);

        curr.append('1');
        solve(n, curr);
        curr.deleteCharAt(curr.length() - 1);
    }
}
