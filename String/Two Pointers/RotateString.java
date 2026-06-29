//NOT OPTIMAL

class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s+s).contains(goal);
    }
}

//OPTIMAL KMP(Knuth-Morris-Pratt) algorithm

