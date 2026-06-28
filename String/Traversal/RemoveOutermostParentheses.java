//Algorithm

//1. Initialize count = 0 and an empty string result.
//2. Traverse each character in the string:
//   a) If character is '(':
//      - If count > 0, add '(' to result.
//      - Increment count.
//   b) Else (character is ')'):
//      - Decrement count.
//      - If count > 0, add ')' to result.
//3. Return result.

class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        String result = "";
        for(int i = 0;i<s.length(); i++){
            if(s.charAt(i) == '('){
                if(count > 0){
                    result += '(';
                }
                count++;
            }else{
                count--;

                if(count > 0){
                    result += ')';
                }
            }
        }

        return result;
    }
}