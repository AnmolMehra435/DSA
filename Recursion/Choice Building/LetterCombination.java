//1. If all digits are processed
//      -> Store the current string and return.
//
//2. Get the letters mapped to the current digit.
//
//3. For each letter:
//      -> Add the letter.
//      -> Recurse for the next digit.
//      -> Backtrack by removing the last letter.
//
//4. Repeat until all combinations are generated.

class Solution {
    String map[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result);

        return result;
    }

    public void backtrack(String digits,int index, StringBuilder string, List<String> result){
        if(index == digits.length()){
            result.add(string.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];
        char[] chars = letters.toCharArray();

        for(char ch: chars){
            string.append(ch);
            backtrack(digits, index + 1, string, result);
            string.deleteCharAt(string.length() - 1);
        }
    }
}