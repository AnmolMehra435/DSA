//Algorithm

//Initialize result
//Set end = n - 1
//
//While end >= 0:
//    Skip all dots
//
//    Mark current position as word end
//
//    Move left until dot or start of string
//
//    Add '.' if result is not empty
//
//    Append current word to result
//
//    Move to previous character
//
//Return result

class Solution {
    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int end = n - 1;

        while (end >= 0) {

            // Skip extra dots
            while (end >= 0 && s.charAt(end) == '.') {
                end--;
            }

            if (end < 0) break;

            // Mark end of current word
            int start = end;

            // Find beginning of current word
            while (start >= 0 && s.charAt(start) != '.') {
                start--;
            }

            // Add dot before every word except first
            if (result.length() > 0) {
                result.append('.');
            }

            // Append current word
            for (int i = start + 1; i <= end; i++) {
                result.append(s.charAt(i));
            }

            // Move to previous word
            end = start - 1;
        }

        return result.toString();
    }
}