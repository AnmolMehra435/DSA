//Note - This is not the optimal approach to solve this problem (optimal -- String traversal)

//Algorithm (Recursive - String to Integer (atoi))
//
//1. Skip all leading whitespaces.
//2. If the string becomes empty, return 0.
//3. Determine the sign (+ or -).
//4. Start recursion with:
//   - current index
//   - current number (curr = 0 as long)
//   - sign
//
//5. Base Case:
//   - If end of string is reached or current character is not a digit:
//     - Apply the sign.
//     - If value > Integer.MAX_VALUE, return Integer.MAX_VALUE.
//     - If value < Integer.MIN_VALUE, return Integer.MIN_VALUE.
//     - Otherwise, return the integer value.
//
//6. Recursive Step:
//   - Convert the current character to its digit.
//   - Update the number:
//       curr = curr * 10 + digit
//   - Apply the sign and check for overflow.
//   - If overflow occurs, return the corresponding limit.
//   - Otherwise, recursively process the next character.
//
//7. Return the final parsed integer.
//
//Time Complexity: O(n)
//Space Complexity: O(n) (Recursion Stack)

class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) return 0;

        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        return solve(i, 0L, s, sign);
    }

    private int solve(int i, long curr, String s, int sign) {
        if (i == s.length()) {
            curr *= sign;

            if (curr > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (curr < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            return (int) curr;
        }

        char ch = s.charAt(i);

        if (!Character.isDigit(ch)) {
            curr *= sign;

            if (curr > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (curr < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            return (int) curr;
        }

        curr = curr * 10 + (ch - '0');

        long value = curr * sign;
        if (value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (value < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return solve(i + 1, curr, s, sign);
    }
}