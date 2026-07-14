//Algorithm:
//
//1. Create an empty ArrayList to store all subsets.
//2. Create an empty StringBuilder to build the current subset.
//3. Start recursion from index 0.
//4. If the current index reaches the end of the string:
//      - Add the current subset to the result.
//      - Return.
//5. Include the current character:
//      - Append it to StringBuilder.
//      - Recurse for the next index.
//6. Backtrack:
//      - Remove the last character from StringBuilder.
//7. Exclude the current character:
//      - Recurse for the next index.
//8. After recursion finishes, return the result.

class Solution {
    public ArrayList<String> powerSet(String s) {
        // code here
        ArrayList<String> result = new ArrayList<>();

        result.add("");

        StringBuilder str = new StringBuilder();

        solve(result, s, 0, str);

        return result;
    }

    public void solve(ArrayList<String> result, String s, int idx, StringBuilder str){
        if(idx == s.length()){
            result.add(str.toString());
            return;
        }

        str.append(s.charAt(idx));

        solve(result, s, idx + 1, str);

        str.deleteCharAt(str.length() - 1);

        solve(result, s, idx + 1, str);
    }
}
