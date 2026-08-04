//1. Start from index = 0 with an empty partition list.
//
//2. For every possible substring from current index to end:
//   - Check if the substring is a palindrome.
//   - If yes:
//       • Add it to the current partition.
//       • Recursively partition the remaining string.
//       • Backtrack by removing the last substring.
//
//3. If the current index reaches the end of the string:
//   - Store the current partition in the answer.
//
//Palindrome Check:
//- Compare characters from both ends moving inward.
//- If all characters match, it is a palindrome.

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                path.add(s.substring(start, i+1));
                backtrack(s, i+1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}