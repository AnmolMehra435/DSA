//Algorithm

//1. Initialize start = 0 and an empty StringBuilder.
//2. Traverse the string using an index end.
//3. Whenever a space or the end of the string is reached:
//   a) Traverse backwards from end - 1 to start and append characters to the result.
//   b) Append a space if it is not the end of the string.
//   c) Update start = end + 1.
//4. Return the final string.

class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int start = 0;

        for (int end = 0; end <= s.length(); end++) {
            if (end == s.length() || s.charAt(end) == ' ') {

                for (int i = end - 1; i >= start; i--) {
                    ans.append(s.charAt(i));
                }

                if (end != s.length()) {
                    ans.append(' ');
                }

                start = end + 1;
            }
        }

        return ans.toString();
    }
}