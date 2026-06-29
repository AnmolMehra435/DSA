//Algorithm:
//
//1. Initialize start = 0 and maxLen = 0.
//2. Traverse each character of the string and treat it as the center of a palindrome.
//3. For each index i:
//   a) Find the length of the odd-length palindrome by expanding around (i, i).
//   b) Find the length of the even-length palindrome by expanding around (i, i + 1).
//4. Take the maximum of the two lengths.
//5. If the current palindrome length is greater than maxLen, update maxLen and starting index.
//6. After checking all centers, return the substring from start to start + maxLen.
//
//Time Complexity: O(n²)
//Space Complexity: O(1)

//The theoretically optimal solution is Manacher's Algorithm

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;

        for(int i = 0; i<s.length(); i++){
            int len1= expand(s, i, i);
            int len2 = expand(s, i, i+1);

            int len = Math.max(len1, len2);

            if(len > maxLen){
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
