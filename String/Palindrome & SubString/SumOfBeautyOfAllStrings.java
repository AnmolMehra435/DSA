//Algorithm

//1. Initialize ans = 0.
//
//2. For every starting index i:
//      Create a frequency array of size 26.
//
//3. For every ending index j from i to n-1:
//      Increment frequency of s[j].
//
//      Find:
//          maxFreq = maximum frequency
//          minFreq = minimum non-zero frequency
//
//      Add (maxFreq - minFreq) to ans.
//
//4. Return ans.

class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }

                ans += (maxFreq - minFreq);
            }
        }

        return ans;
    }
}