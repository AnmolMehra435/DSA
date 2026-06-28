//Algorithm

//1. Initialize count = 0 and maxDepth = 0.
//2. Traverse each character of the string:
//   a) If character is '(', increment count and update maxDepth.
//   b) If character is ')', decrement count.
//3. Return maxDepth.

class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                count++;
                max = Math.max(count, max);
            }else if(ch == ')'){
                count--;
            }
        }
        return max;
    }
}