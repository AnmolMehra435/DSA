//This is not the optimal solution the Optimal solution is using DP

//Algorithm

//1. Start from index = 0.
//
//2. If the current index reaches the end of the string,
//   return true.
//
//3. Try every possible substring starting from the current index.
//
//4. If the substring exists in the dictionary:
//      • Recursively check the remaining string from the next index.
//
//5. If any recursive call returns true,
//   return true.
//
//6. If no valid substring leads to the end,
//   return false.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return solve(s, 0, set);
    }

    private boolean solve(String s, int start, HashSet<String> set){
        if(start == s.length()){
            return true;
        }

        for(int i = start; i<s.length(); i++){
            if(set.contains(s.substring(start, i+1))){
                if(solve(s, i+1, set)){
                    return true;
                }
            }
        }

        return false;
    }
}