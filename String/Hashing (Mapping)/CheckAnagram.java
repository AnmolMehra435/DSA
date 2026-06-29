//Algorithm

//1. If s.length != t.length, return false.
//2. Create freq[26] initialized with 0.
//3. For each index i:
//      freq[s.charAt(i) - 'a']++
//      freq[t.charAt(i) - 'a']--
//4. Check all elements of freq:
//      If any element != 0, return false.
//5. Return true.

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            int idx1 = ch1 - 'a';
            int idx2 = ch2 - 'a';
            freq[idx1]++;
            freq[idx2]--;
        }

        for(int i = 0; i<26; i++){
            if(freq[i] != 0){
                return false;
            }
        }

        return true;
    }
}