//Algorithm

//1. Create an empty HashSet to store unique substrings.
//2. Use two nested loops:
//   - Outer loop (i) represents the starting index.
//   - Inner loop (j) represents the ending index.
//3. Generate each substring using s.substring(i, j) and add it to the HashSet.
//4. Since HashSet stores only unique elements, duplicate substrings are automatically ignored.
//5. Return the size of the HashSet as the count of distinct substrings.
//
//Time Complexity: O(n³)
//Space Complexity: O(n²)

class Solution {
    public static int countSubs(String s) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }

        return set.size();
    }
}

//The Optimal solution for this is to use a Trie data structure