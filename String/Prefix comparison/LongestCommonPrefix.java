//Algorithm

//1. Take the first string as the reference string.
//
//2. Traverse each character of the first string.
//
//3. For every character position i:
//      - Compare the character with the character at index i in all other strings.
//      - If any string ends or characters do not match, return the substring from index 0 to i.
//
//4. If all characters of the first string match in every string, return the first string.

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for(int i =0; i<first.length(); i++){
            char c = first.charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}