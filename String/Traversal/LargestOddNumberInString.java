//Algorithm

//1. Start from the last digit of the string.
//2. Move left until an odd digit is found.
//3. If no odd digit is found, return "".
//4. Otherwise, return the substring from index 0 to the position of the rightmost odd digit (inclusive).

class Solution {
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        while(i>=0){
            char ch = num.charAt(i);
            int idx = ch - '0';

            if(idx % 2 == 1){
                break;
            }
            i--;
        }

        return i < 0 ? "": num.substring(0, i+1);

    }
}