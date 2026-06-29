//Algorithm


//0. Convert string to lowercase
//1. Initialize two pointers: start at the beginning and end at the last character.
//2. While start is less than end:
//   - If characters at start and end are different, return false.
//   - Move start forward and end backward.
//3. If all characters match, return true.

class Solution {
    public static boolean isPalindrome(String s) {
        // code here
        String str = s.toLowerCase();
        int start = 0;
        int end = str.length() - 1;

        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}